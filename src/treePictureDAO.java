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
@WebServlet("/treePictureDAO")
public class treePictureDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public treePictureDAO(){}
	
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
    
    public List<treePicture> listAllTreePicture() throws SQLException {
    	//System.out.println("inside admin");
        List<treePicture> listTreePicture = new ArrayList<treePicture>();        
        String sql = "SELECT * FROM TreePicture";      
        connect_func("root","root1234");      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String pictureID = resultSet.getString("PictureID");
        	String pictureURL = resultSet.getString("PictureURL");
        	String treeInfoID = resultSet.getString("TreeInfoID");

        	treePicture treePicture = new treePicture(pictureID, pictureURL, treeInfoID);



            listTreePicture.add(treePicture);
        }
        System.out.println(listTreePicture);
        resultSet.close();
        disconnect();        
        return listTreePicture;
    }
    
    public void insert(treePicture treePicture) throws SQLException {
    	System.out.println("Inside insert treeInformation");
    	connect_func("root","root1234");         
		String sql = "insert into treePicture(pictureID, pictureURL, treeInfoID) values (?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, treePicture.getPictureID());
			preparedStatement.setString(2, treePicture.getPictureURL());
			preparedStatement.setString(3, treePicture.getTreeInfoID());
		
			

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
   
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }

}
