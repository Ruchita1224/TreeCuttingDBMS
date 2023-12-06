import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/clientSummaryDAO")
public class clientSummaryDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public clientSummaryDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/treecuttingdb?allowPublicKeyRetrieval=true&useSSL=false&user=root&password=root1234");
            System.out.println(connect);
            System.out.println("Connection successfull");
        }
    }

	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/treecuttingdb?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
            System.out.println("Connection successfull");
        }
    }
    
    public List<clientSummary> listClientSummary() throws SQLException {
    	//System.out.println("inside admin");
        List<clientSummary> listClientSummary = new ArrayList<clientSummary>();        
        String sql = "SELECT c.ClientID, c.FirstName, c.LastName,  COUNT(tr.RequestID) AS TotalTrees, SUM(q.Price) AS TotalDueAmount, COALESCE(SUM(CASE WHEN bd.Status = 'Paid' THEN bd.Amount ELSE 0 END), 0) AS TotalPaidAmount, GROUP_CONCAT(DISTINCT tr.RequestDate) AS WorkDoneDates FROM Client c "
        		+ "LEFT JOIN TreeRequest tr ON c.ClientID = tr.ClientID "
        		+ "LEFT JOIN Quote q ON tr.RequestID = q.RequestID "
        		+ "LEFT JOIN OrderDetails od ON q.QuoteID = od.QuoteID "
        		+ "LEFT JOIN BillDetails bd ON od.OrderID = bd.OrderID "
        		+ "WHERE bd.Status = 'Paid' "
        		+ "GROUP BY c.ClientID, c.FirstName, c.LastName;";      
        connect_func("root","root1234");      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String clientID = resultSet.getString("ClientID");
        	String firstName = resultSet.getString("FirstName");
        	String lastName = resultSet.getString("LastName");
        	int totalTrees = resultSet.getInt("TotalTrees");
            double totalDueAmount = resultSet.getDouble("TotalDueAmount");
            double totalPaidAmount = resultSet.getDouble("TotalPaidAmount");
            String workDoneDatesString = resultSet.getString("WorkDoneDates");
            List<String> workDoneDates = parseWorkDoneDates(workDoneDatesString);

            clientSummary clientSummary = new clientSummary(clientID, firstName, lastName,
                    totalTrees, totalDueAmount, totalPaidAmount, workDoneDates);
            listClientSummary.add(clientSummary);
        }
        System.out.println(listClientSummary);
        resultSet.close();
        disconnect();        
        return listClientSummary;
    }
    
    private List<String> parseWorkDoneDates(String workDoneDatesString) {
        List<String> workDoneDates = new ArrayList<>();
        if (workDoneDatesString != null) {
            String[] dateArray = workDoneDatesString.split(",");
            for (String date : dateArray) {
                workDoneDates.add(date.trim());
            }
        }
        return workDoneDates;
    }
    
  
    
  
    
   
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }

}
