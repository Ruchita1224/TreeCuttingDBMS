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
@WebServlet("/adminDAO")
public class adminDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public adminDAO(){}
	
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
    
    public void insert(admin admin) throws SQLException {
    	System.out.println("Inside insert admin");
    	connect_func("root","root1234");         
		String sql = "insert into Admin(LoginID, Password, ActionPerformed,Timestamp) values (?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, admin.getLoginID());
			preparedStatement.setString(2, admin.getPassword());
			preparedStatement.setString(3, admin.getActionPerformed());	
			preparedStatement.setDate(4, (java.sql.Date) admin.getTimestamp());

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public List<admin> listAllAdmins() throws SQLException {
    	System.out.println("inside admin");
        List<admin> listAdmin = new ArrayList<admin>();        
        String sql = "SELECT * FROM Admin";      
        connect_func("root","root1234");      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String loginID = resultSet.getString("loginID");
            String password = resultSet.getString("password");
            String actionPerformed = resultSet.getString("actionPerformed");
            Date timestamp = resultSet.getDate("timestamp");

             
            admin admins = new admin(loginID,password, actionPerformed, timestamp);
            listAdmin.add(admins);
        }
        System.out.println(listAdmin);
        resultSet.close();
        disconnect();        
        return listAdmin;
    }
   
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }

}
