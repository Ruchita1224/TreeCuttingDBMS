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
@WebServlet("/clientDAO")
public class clientDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public clientDAO(){}
	
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
    
    public List<client> listAllClient() throws SQLException {
    	//System.out.println("inside admin");
        List<client> listClient = new ArrayList<client>();        
        String sql = "SELECT * FROM client";      
        connect_func("root","root1234");      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String clientID = resultSet.getString("ClientID");
        	String firstName = resultSet.getString("FirstName");
        	String lastName = resultSet.getString("LastName");
        	String address = resultSet.getString("Address");
        	String creditCardInfo = resultSet.getString("CreditCardInfo");
        	String phoneNumber = resultSet.getString("PhoneNumber");
        	String email = resultSet.getString("Email");

        	client clients = new client(clientID, firstName, lastName, address, creditCardInfo, phoneNumber, email);

            listClient.add(clients);
        }
        System.out.println(listClient);
        resultSet.close();
        disconnect();        
        return listClient;
    }
    
    public List<client> listGoodClients() throws SQLException {
    	//System.out.println("inside admin");
        List<client> listGoodClients = new ArrayList<client>();        
        String sql = "SELECT c.ClientID, c.FirstName, c.LastName, c.Address, c.CreditCardInfo, c.PhoneNumber, c.Email "
        		+ "FROM Client c "
        		+ "WHERE EXISTS ( "
        		+ "    SELECT 1 "
        		+ "    FROM BillDetails bd "
        		+ "    JOIN OrderDetails od ON bd.OrderID = od.OrderID "
        		+ "    JOIN Quote q ON od.QuoteID = q.QuoteID "
        		+ "    JOIN TreeRequest tr ON q.RequestID = tr.RequestID "
        		+ "    WHERE tr.ClientID = c.ClientID "
        		+ "      AND bd.Status = 'Paid' "
        		+ "      AND bd.BilledDate BETWEEN tr.RequestDate AND DATE_ADD(tr.RequestDate, INTERVAL 1 DAY) "
        		+ "); "
        		+ "";      
        connect_func("root","root1234");      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String clientID = resultSet.getString("ClientID");
        	String firstName = resultSet.getString("FirstName");
        	String lastName = resultSet.getString("LastName");
        	String address = resultSet.getString("Address");
        	String creditCardInfo = resultSet.getString("CreditCardInfo");
        	String phoneNumber = resultSet.getString("PhoneNumber");
        	String email = resultSet.getString("Email");

        	client clients = new client(clientID, firstName, lastName, address, creditCardInfo, phoneNumber, email);

        	listGoodClients.add(clients);
        }
        System.out.println(listGoodClients);
        resultSet.close();
        disconnect();        
        return listGoodClients;
    }
    
    public List<client> listBadClients() throws SQLException {
    	//System.out.println("inside admin");
        List<client> listBadClients = new ArrayList<client>();        
        String sql = "SELECT c.ClientID, c.FirstName, c.LastName, c.Address, c.CreditCardInfo, c.PhoneNumber, c.Email\r\n"
        		+ "FROM Client c "
        		+ "WHERE NOT EXISTS ( "
        		+ "    SELECT 1 "
        		+ "    FROM BillDetails bd "
        		+ "    JOIN OrderDetails od ON bd.OrderID = od.OrderID "
        		+ "    JOIN Quote q ON od.QuoteID = q.QuoteID "
        		+ "    JOIN TreeRequest tr ON q.RequestID = tr.RequestID "
        		+ "    WHERE tr.ClientID = c.ClientID "
        		+ "      AND bd.Status <> 'Paid' "
        		+ "      AND bd.BilledDate <= DATE_SUB(NOW(), INTERVAL 1 WEEK) "
        		+ "); "
        		+ "";      
        connect_func("root","root1234");      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String clientID = resultSet.getString("ClientID");
        	String firstName = resultSet.getString("FirstName");
        	String lastName = resultSet.getString("LastName");
        	String address = resultSet.getString("Address");
        	String creditCardInfo = resultSet.getString("CreditCardInfo");
        	String phoneNumber = resultSet.getString("PhoneNumber");
        	String email = resultSet.getString("Email");

        	client clients = new client(clientID, firstName, lastName, address, creditCardInfo, phoneNumber, email);

        	listBadClients.add(clients);
        }
        System.out.println(listBadClients);
        resultSet.close();
        disconnect();        
        return listBadClients;
    }
    
    public void insert(client client) throws SQLException {
    	System.out.println("Inside insert client");
    	connect_func("root","root1234");
    	
		String sql = "insert into client(ClientID, FirstName, LastName, Address, CreditCardInfo, PhoneNumber, Email) values (?, ?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, client.getClientID());
			preparedStatement.setString(2, client.getFirstName());
			preparedStatement.setString(3, client.getLastName());
			preparedStatement.setString(4, client.getAddress());
			preparedStatement.setString(5, client.getCreditCardInfo());
			preparedStatement.setString(6, client.getPhoneNumber());
			preparedStatement.setString(7, client.getEmail());
			
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
   
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }

}
