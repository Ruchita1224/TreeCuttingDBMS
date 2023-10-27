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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/treeRequestDAO")
public class treeRequestDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public treeRequestDAO(){}
	
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
    
    public List<treeRequest> listAllTreeRequest() throws SQLException {
        List<treeRequest> listTreeRequest = new ArrayList<treeRequest>();        
        String sql = "SELECT * FROM TreeRequest";      
        connect_func("root","root1234");      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String requestID = resultSet.getString("RequestID");
        	String clientID = resultSet.getString("ClientID");
        	Date requestDate = resultSet.getDate("RequestDate");
        	String status = resultSet.getString("Status");
        	String note = resultSet.getString("Note");

        	treeRequest treeRequest = new treeRequest(requestID, clientID, requestDate, status, note);



            listTreeRequest.add(treeRequest);
        }
        System.out.println(listTreeRequest);
        resultSet.close();
        disconnect();        
        return listTreeRequest;
    }
   
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }

}
