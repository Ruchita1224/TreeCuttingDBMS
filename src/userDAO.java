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
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/userDAO")
public class userDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public userDAO(){}
	
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

    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(user users) throws SQLException {
    	connect_func("root","root1234");         
		String sql = "insert into User(userName, password, role) values (?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, users.getUsername());
			preparedStatement.setString(2, users.getPassword());
			preparedStatement.setString(3, users.getRole());		

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
   
    public boolean checkUsername(String username) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE username = ?";
    	connect_func("root","root1234");
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
   
    public String isValid(String username, String password) throws SQLException
    {
    	System.out.println("Inside isvalid");
    	String sql = "SELECT * FROM User where username = ? and password = ?";
    	connect_func("root","root1234");
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
    	ResultSet resultSet = preparedStatement.executeQuery();
    	
    	if(resultSet.next()) {
    			String role = getUserRole(username);
    			System.out.println(role);
    			return role;
    		}		
    	return null;
    }
    
  public String getUserRole(String username) throws SQLException {
	String sql = "SELECT Role FROM User WHERE username = ?";
	connect_func("root","root1234");
	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    preparedStatement.setString(1, username);
    ResultSet resultSet = preparedStatement.executeQuery();
   	String role = null;
    if (resultSet.next()) {
    	role = resultSet.getString("Role");
    }
    
    System.out.println(role);
   	return role;
}

    
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func("root","root1234");
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"drop database if exists treecuttingdb; ",
					        "create database treecuttingdb; ",
					        "use treecuttingdb; ",
					        "drop table if exists Client; ",
					        ("CREATE TABLE if not exists Client( " +
					        		"ClientID VARCHAR (50) PRIMARY KEY, "+
					        		"FirstName VARCHAR (100)," +
					        		"LastName VARCHAR (100), " +
					        		"Address VARCHAR (255), " +
					        		"CreditCardInfo VARCHAR (50), " +
					        		"PhoneNumber VARCHAR (50), " +
					        		"Email VARCHAR (100) "+"); "),
					        "drop table if exists TreeRequest; ",
					        ("CREATE TABLE TreeRequest ( "
					        		+ "RequestID VARCHAR (100) PRIMARY KEY,"
					        		+ "ClientID VARCHAR (50),"
					        		+ "RequestDate DATE,"
					        		+ "Status VARCHAR (100),"
					        		+ "Note VARCHAR (255),"
					        		+ "FOREIGN KEY (ClientID) REFERENCES Client (ClientID)"
					        		+ ");"),
					        "drop table if exists TreeInformation; ",
					         ("CREATE TABLE TreeInformation ("
					         		+ "TreeInfoID VARCHAR (100) PRIMARY KEY,"
					         		+ "RequestID VARCHAR (100),"
					         		+ "Size DECIMAL (5, 2),"
					         		+ "Height DECIMAL (5, 2),"
					         		+ "Location VARCHAR (100),"
					         		+ "NearHouse BOOLEAN,"
					         		+ "FOREIGN KEY (RequestID) REFERENCES TreeRequest (RequestID)"
					         		+ ");"),
					         "drop table if exists TreePicture; ",
					         ("CREATE TABLE TreePicture ("
					         		+ "PictureID VARCHAR (100) PRIMARY KEY,"
					         		+ "PictureURL VARCHAR(255),"
					         		+ "TreeInfoID VARCHAR (100),"
					         		+ "FOREIGN KEY (TreeInfoID) REFERENCES TreeInformation(TreeInfoID)"
					         		+ ");"),
					         "drop table if exists Quote; ",
					         ("CREATE TABLE Quote ("
					         		+ "QuoteID VARCHAR (100) PRIMARY KEY,"
					         		+ "RequestID VARCHAR (100),"
					         		+ "QuoteDate DATE,"
					         		+ "Price DECIMAL(10, 2),"
					         		+ "TimeWindow VARCHAR(100),"
					         		+ "Status VARCHAR(100),"
					         		+ "Note VARCHAR (255),"
					         		+ "FOREIGN KEY (RequestID) REFERENCES TreeRequest(RequestID)"
					         		+ ");"),
					         "drop table if exists OrderDetails; ",
					         ("CREATE TABLE OrderDetails ("
					         		+ "OrderID varchar(100) PRIMARY KEY,"
					         		+ "QuoteID varchar(100),"
					         		+ "OrderDate DATE,"
					         		+ "Status VARCHAR(100),"
					         		+ "FOREIGN KEY (QuoteID) REFERENCES Quote(QuoteID)"
					         		+ ");"),
					         "drop table if exists BillDetails; ",
					         ("CREATE TABLE BillDetails ("
					         		+ "BillID varchar(100) PRIMARY KEY,"
					         		+ "OrderID varchar(100),"
					         		+ "BilledDate DATE,"
					         		+ "Amount DECIMAL(10, 2),"
					         		+ "Status VARCHAR(100),"
					         		+ "Note varchar(255),"
					         		+ "FOREIGN KEY (OrderID) REFERENCES OrderDetails(OrderID)"
					         		+ ");"),
					         "drop table if exists Admin; ",
					         ("CREATE TABLE Admin ("
					         		+ "LoginID VARCHAR(100) PRIMARY KEY,"
					        		+ "Password VARCHAR(100),"
					         		+ "ActionPerformed VARCHAR(100),"
					         		+ "Timestamp DATETIME"
					         		+ ");"),
					         "drop table if exists user; ",
					         ("CREATE TABLE user ("
					         		+ "ID INT AUTO_INCREMENT PRIMARY KEY,"
					        		+ "Username VARCHAR(50) NOT NULL,"
					         		+ "Password VARCHAR(255) NOT NULL,"
					         		+ "Role ENUM('David Smith', 'Client', 'Admin Root') NOT NULL"
					         		+ ");")
        					};
        
        String[] TUPLES = {
        	    "INSERT INTO Client (ClientID, FirstName, LastName, Address, CreditCardInfo, PhoneNumber, Email) VALUES " +
        	        "('1', 'John', 'Doe', '123 Main St', '1234-5678-9012-3456', '555-555-5555', 'john.doe@email.com')," +
        	        "('2', 'Jane', 'Smith', '456 Elm St', '9876-5432-1098-7654', '666-666-6666', 'jane.smith@email.com')," +
        	        "('3', 'Mike', 'Johnson', '789 Oak St', '5678-1234-9876-5432', '777-777-7777', 'mike.johnson@email.com')," +
        	        "('4', 'Sarah', 'Brown', '101 Pine St', '4321-8765-5432-1098', '888-888-8888', 'sarah.brown@email.com')," +
        	        "('5', 'David', 'Wilson', '1111 Cedar St', '8765-4321-7654-3210', '999-999-9999', 'david.wilson@email.com')," +
        	        "('6', 'Linda', 'Lee', '2222 Birch St', '2345-6789-2109-8765', '101-101-1010', 'linda.lee@email.com')," +
        	        "('7', 'Robert', 'Davis', '3333 Maple St', '6789-2345-4321-9876', '202-202-2020', 'robert.davis@email.com')," +
        	        "('8', 'Emily', 'White', '4444 Redwood St', '8765-4321-7654-3210', '303-303-3030', 'emily.white@email.com')," +
        	        "('9', 'Chris', 'Taylor', '5555 Walnut St', '1234-5678-9012-3456', '404-404-4040', 'chris.taylor@email.com')," +
        	        "('10', 'Megan', 'Miller', '6666 Poplar St', '5678-1234-9876-5432', '505-505-5050', 'megan.miller@email.com')",

        	    "INSERT INTO TreeRequest (RequestID, ClientID, RequestDate, Status, Note) VALUES " +
        	        "('1', '1', '2023-01-01', 'Pending', 'Tree trimming needed')," +
        	        "('2', '2', '2023-01-02', 'Pending', 'Tree removal requested')," +
        	        "('3', '3', '2023-01-03', 'Completed', 'Tree assessment completed')," +
        	        "('4', '4', '2023-01-04', 'In Progress', 'Emergency tree service')," +
        	        "('5', '5', '2023-01-05', 'Pending', 'Tree inspection required')," +
        	        "('6', '6', '2023-01-06', 'In Progress', 'Tree pruning in progress')," +
        	        "('7', '7', '2023-01-07', 'Completed', 'Tree removal completed')," +
        	        "('8', '8', '2023-01-08', 'Pending', 'Tree trimming needed')," +
        	        "('9', '9', '2023-01-09', 'In Progress', 'Tree inspection in progress')," +
        	        "('10', '10', '2023-01-10', 'Pending', 'Tree assessment required')",

        	    "INSERT INTO TreeInformation (TreeInfoID, RequestID, Size, Height, Location, NearHouse) VALUES " +
        	        "('1', '1', 10.5, 25.3, 'Front Yard', 1)," +
        	        "('2', '2', 15.2, 30.0, 'Backyard', 0)," +
        	        "('3', '3', 8.7, 20.1, 'Side Yard', 1)," +
        	        "('4', '4', 12.3, 28.5, 'Front Yard', 1)," +
        	        "('5', '5', 9.8, 22.0, 'Backyard', 0)," +
        	        "('6', '6', 14.1, 32.7, 'Side Yard', 1)," +
        	        "('7', '7', 11.0, 26.6, 'Front Yard', 1)," +
        	        "('8', '8', 7.5, 18.4, 'Backyard', 0)," +
        	        "('9', '9', 13.4, 31.2, 'Side Yard', 1)," +
        	        "('10', '10', 10.9, 24.8, 'Front Yard', 1)",

        	    "INSERT INTO TreePicture (PictureID, PictureURL, TreeInfoID) VALUES " +
        	        "('1', 'http://example.com/tree1.jpg', '1')," +
        	        "('2', 'http://example.com/tree2.jpg', '2')," +
        	        "('3', 'http://example.com/tree3.jpg', '3')," +
        	        "('4', 'http://example.com/tree4.jpg', '4')," +
        	        "('5', 'http://example.com/tree5.jpg', '5')," +
        	        "('6', 'http://example.com/tree6.jpg', '6')," +
        	        "('7', 'http://example.com/tree7.jpg', '7')," +
        	        "('8', 'http://example.com/tree8.jpg', '8')," +
        	        "('9', 'http://example.com/tree9.jpg', '9')," +
        	        "('10', 'http://example.com/tree10.jpg', '10')",

        	    "INSERT INTO Quote (QuoteID, RequestID, QuoteDate, Price, TimeWindow, Status, Note) VALUES " +
        	        "('1', '1', '2023-01-15', 500.00, '8:00 AM - 12:00 PM', 'Pending', 'Initial quote')," +
        	        "('2', '2', '2023-01-16', 750.00, '9:00 AM - 1:00 PM', 'Pending', 'Custom quote')," +
        	        "('3', '3', '2023-01-17', 400.00, '10:00 AM - 2:00 PM', 'Accepted', 'Standard quote')," +
        	        "('4', '4', '2023-01-18', 600.00, '11:00 AM - 3:00 PM', 'Pending', 'Emergency quote')," +
        	        "('5', '5', '2023-01-19', 550.00, '12:00 PM - 4:00 PM', 'Pending', 'Detailed quote')," +
        	        "('6', '6', '2023-01-20', 700.00, '1:00 PM - 5:00 PM', 'Accepted', 'Custom quote')," +
        	        "('7', '7', '2023-01-21', 800.00, '2:00 PM - 6:00 PM', 'Completed', 'Final quote')," +
        	        "('8', '8', '2023-01-22', 450.00, '3:00 PM - 7:00 PM', 'Pending', 'Standard quote')," +
        	        "('9', '9', '2023-01-23', 650.00, '4:00 PM - 8:00 PM', 'In Progress', 'Custom quote')," +
        	        "('10', '10', '2023-01-24', 600.00, '5:00 PM - 9:00 PM', 'Pending', 'Standard quote')",

        	    "INSERT INTO OrderDetails (OrderID, QuoteID, OrderDate, Status) VALUES " +
        	        "('1', '1', '2023-01-25', 'Processing')," +
        	        "('2', '2', '2023-01-26', 'Pending')," +
        	        "('3', '3', '2023-01-27', 'Completed')," +
        	        "('4', '4', '2023-01-28', 'In Progress')," +
        	        "('5', '5', '2023-01-29', 'Processing')," +
        	        "('6', '6', '2023-01-30', 'Pending')," +
        	        "('7', '7', '2023-01-31', 'Completed')," +
        	        "('8', '8', '2023-02-01', 'Processing')," +
        	        "('9', '9', '2023-02-02', 'In Progress')," +
        	        "('10', '10', '2023-02-03', 'Pending')",

        	    "INSERT INTO BillDetails (BillID, OrderID, BilledDate, Amount, Status, Note) VALUES " +
        	        "('1', '1', '2023-02-10', 500.00, 'Paid', 'Payment received')," +
        	        "('2', '2', '2023-02-11', 750.00, 'Pending', 'Payment due')," +
        	        "('3', '3', '2023-02-12', 400.00, 'Paid', 'Payment received')," +
        	        "('4', '4', '2023-02-13', 600.00, 'Processing', 'Payment processing')," +
        	        "('5', '5', '2023-02-14', 550.00, 'Pending', 'Payment pending')," +
        	        "('6', '6', '2023-02-15', 700.00, 'Paid', 'Payment received')," +
        	        "('7', '7', '2023-02-16', 800.00, 'Completed', 'Payment complete')," +
        	        "('8', '8', '2023-02-17', 450.00, 'Pending', 'Payment due')," +
        	        "('9', '9', '2023-02-18', 650.00, 'Processing', 'Payment processing')," +
        	        "('10', '10', '2023-02-19', 600.00, 'Pending', 'Payment pending')",

        	    "INSERT INTO Admin (LoginID, Password , ActionPerformed, Timestamp) VALUES " +
        	        "('root', 'Root*1234', 'Database setup', '2023-03-01 10:00:00')," +
        	        "('admin2','Root*1234', 'Data insertion', '2023-03-02 11:00:00')," +
        	        "('admin3','Root*1234', 'Data insertion', '2023-03-03 12:00:00')," +
        	        "('admin4','Root*1234', 'Data insertion', '2023-03-04 13:00:00')," +
        	        "('admin5','Root*1234', 'Data insertion', '2023-03-05 14:00:00')," +
        	        "('admin6','Root*1234', 'Data insertion', '2023-03-06 15:00:00')," +
        	        "('admin7','Root*1234', 'Data insertion', '2023-03-07 16:00:00')," +
        	        "('admin8','Root*1234', 'Data insertion', '2023-03-08 17:00:00')," +
        	        "('admin9','Root*1234', 'Data insertion', '2023-03-09 18:00:00')," +
        	        "('admin10','Root*1234', 'Data insertion', '2023-03-10 19:00:00')",
        	        
        	        "INSERT INTO User (Username, Password, Role) VALUES " +
        	                "('davidsmith', 'davidsmith', 'David Smith')," +
        	                "('clientuser', 'clientuser', 'Client')," +
        	                "('adminroot', 'adminroot', 'Admin Root')"
        	};

        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
