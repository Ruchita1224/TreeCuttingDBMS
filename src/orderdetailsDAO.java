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
@WebServlet("/orderdetailsDAO")
public class orderdetailsDAO
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public orderdetailsDAO(){}
	
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
    
    public List<orderdetails> listAllOrderDetails() throws SQLException {
    	//System.out.println("inside admin");
        List<orderdetails> listOrderDetails = new ArrayList<orderdetails>();        
        String sql = "SELECT * FROM OrderDetails";      
        connect_func("root","root1234");      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String orderID = resultSet.getString("OrderID");
        	String quoteID = resultSet.getString("QuoteID");
        	Date orderDate = resultSet.getDate("OrderDate");
        	String status = resultSet.getString("Status");

        	orderdetails orderDetails = new orderdetails(orderID, quoteID, orderDate, status);

            listOrderDetails.add(orderDetails);
        }
        System.out.println(listOrderDetails);
        resultSet.close();
        disconnect();        
        return listOrderDetails;
    }
    
    public orderdetails listParticularOrder(String username) throws SQLException {
    	System.out.println(username);
        String sql = "Select * from OrderDetails where QuoteID in (SELECT quoteID from quote where RequestID in ( select RequestID from treerequest where ClientID = ? ))";      
        connect_func("root","root1234");
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet);
        if(resultSet.next()) {
        	String orderID = resultSet.getString("OrderID");
        	String quoteID = resultSet.getString("QuoteID");
        	Date orderDate = resultSet.getDate("OrderDate");
        	String status = resultSet.getString("Status");
        	orderdetails orderDetails = new orderdetails(orderID, quoteID, orderDate, status);
        	resultSet.close();
            disconnect();        
            return orderDetails;
		}
		return null;	

       
    }
   
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }

}
