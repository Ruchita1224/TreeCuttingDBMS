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
@WebServlet("/treeInformationDAO")
public class treeInformationDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public treeInformationDAO(){}
	
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
    
 
    
    public List<treeInformation> listAllTreeInformation() throws SQLException {
    	//System.out.println("inside admin");
        List<treeInformation> listTreeInformation = new ArrayList<treeInformation>();        
        String sql = "SELECT * FROM TreeInformation";      
        connect_func("root","root1234");      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String treeInfoID = resultSet.getString("TreeInfoID");
        	String requestID = resultSet.getString("RequestID");
        	double size = resultSet.getDouble("Size");
        	double height = resultSet.getDouble("Height");
        	String location = resultSet.getString("Location");
        	String nearHouse = resultSet.getString("NearHouse");

        	treeInformation treeInformation = new treeInformation(treeInfoID, requestID, size, height, location, nearHouse);


            listTreeInformation.add(treeInformation);
        }
        System.out.println(listTreeInformation);
        resultSet.close();
        disconnect();        
        return listTreeInformation;
    }
    
    public void insert(treeInformation treeInformation) throws SQLException {
    	System.out.println("Inside insert treeInformation");
    	connect_func("root","root1234");
    	System.out.println(treeInformation.getTreeInfoID() + treeInformation.getRequestID() + treeInformation.getSize() + treeInformation.getHeight() + treeInformation.getLocation() + treeInformation.getNearHouse());
		String sql = "insert into treeInformation(treeInfoID, requestID, size, height, location, nearHouse) values (?, ?, ?, ?, ? ,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, treeInformation.getTreeInfoID());
			preparedStatement.setString(2, treeInformation.getRequestID());
			preparedStatement.setDouble(3, treeInformation.getSize());
			preparedStatement.setDouble(4, treeInformation.getHeight());
			preparedStatement.setString(5, treeInformation.getLocation());
			preparedStatement.setString(6, treeInformation.getNearHouse());
			

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
   
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }

}
