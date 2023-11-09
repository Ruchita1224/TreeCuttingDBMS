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
import javax.servlet.http.HttpSession;

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
@WebServlet("/quoteDAO")
public class quoteDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public quoteDAO(){}
	
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
    
    public List<quote> listAllQuote() throws SQLException {
    	//System.out.println("inside admin");
        List<quote> listQuote = new ArrayList<quote>();        
        String sql = "SELECT * FROM quote";      
        connect_func("root","root1234");      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String quoteID = resultSet.getString("QuoteID");
        	String requestID = resultSet.getString("RequestID");
        	Date quoteDate = resultSet.getDate("QuoteDate");
        	double price = resultSet.getDouble("Price");
        	String timeWindow = resultSet.getString("TimeWindow");
        	String status = resultSet.getString("Status");
        	String note = resultSet.getString("Note");

        	quote quote = new quote(quoteID, requestID, quoteDate, price, timeWindow, status, note);

            listQuote.add(quote);
        }
        System.out.println(listQuote);
        resultSet.close();
        disconnect();        
        return listQuote;
    }
    
    public quote listParticularQuoteRequest(String username) throws SQLException {
    	System.out.println(username);
        String sql = "SELECT * from quote where RequestID in ( select RequestID from treerequest where ClientID = ? )";      
        connect_func("root","root1234");
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet);
        if(resultSet.next()) {
        	String quoteID = resultSet.getString("quoteID");
        	String requestID = resultSet.getString("requestID");
        	Date quoteDate = resultSet.getDate("quoteDate");
        	Double price = resultSet.getDouble("price");
        	String timeWindow = resultSet.getString("timeWindow");
        	String status = resultSet.getString("Status");
        	String note = resultSet.getString("Note");
        	quote quote = new quote(quoteID, requestID, quoteDate, price, timeWindow, status, note);
        	 resultSet.close();
             disconnect();        
             return quote;
		}
		return null;	

       
    }
    
    public void updateQuote(String quoteID, double price, String status, String note) throws SQLException {
        try {
            connect_func("root", "root1234");

            String sql = "UPDATE quote SET Price = ?, Status = ?, Note = ? WHERE QuoteID = ?";
            preparedStatement = (PreparedStatement) connect.prepareStatement(sql);

            preparedStatement.setDouble(1, price);
            preparedStatement.setString(2, status);
            preparedStatement.setString(3, note);
            preparedStatement.setString(4, quoteID);

            preparedStatement.executeUpdate();
            
           

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            disconnect();
        }
    }

    
    public void insert(quote quote) throws SQLException {
    	System.out.println("Inside insert quote");
    	connect_func("root","root1234");
    	
		String sql = "insert into quote(QuoteID, RequestID, QuoteDate, Price, TimeWindow, Status, Note) values (?, ?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, quote.getQuoteID());
			preparedStatement.setString(2, quote.getRequestID());
			preparedStatement.setDate(3, (java.sql.Date) quote.getQuoteDate());
			preparedStatement.setDouble(4, quote.getPrice());
			preparedStatement.setString(5, quote.getTimeWindow());
			preparedStatement.setString(6, quote.getStatus());
			preparedStatement.setString(7, quote.getNote());
			
		preparedStatement.executeUpdate();
		System.out.println("Updated quote");
        preparedStatement.close();
    }
   
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }

}
