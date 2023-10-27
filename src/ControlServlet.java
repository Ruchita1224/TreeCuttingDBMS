import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private adminDAO adminDAO = new adminDAO();
	    private clientDAO clientDAO = new clientDAO();
	    private billDetailsDAO billDetailsDAO = new billDetailsDAO();
	    private orderdetailsDAO orderdetailsDAO = new orderdetailsDAO();
	    private quoteDAO quoteDAO = new quoteDAO();
	    private treeInformationDAO treeInformationDAO = new treeInformationDAO();
	    private treePictureDAO treePictureDAO = new treePictureDAO();
	    private treeRequestDAO treeRequestDAO = new treeRequestDAO();
	    
	    private String currentUser;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	adminDAO = new adminDAO();
	    	billDetailsDAO = new billDetailsDAO();
	    	orderdetailsDAO = new orderdetailsDAO();
	    	quoteDAO = new quoteDAO();
	    	treeInformationDAO = new treeInformationDAO();
	    	treePictureDAO = new treePictureDAO();
	    	treeRequestDAO = new treeRequestDAO();
	    	currentUser= "";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
      	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/initialize":
        		userDAO.init();
        		request.setAttribute("listAdmin", adminDAO.listAllAdmins());
            	request.setAttribute("listBillDetails", billDetailsDAO.listAllBillDetails());
            	request.setAttribute("listClient", clientDAO.listAllClient());
            	request.setAttribute("listOrderDetails", orderdetailsDAO.listAllOrderDetails());
            	request.setAttribute("listQuote", quoteDAO.listAllQuote());
            	request.setAttribute("listTreeInformation", treeInformationDAO.listAllTreeInformation());
            	request.setAttribute("listTreePicture", treePictureDAO.listAllTreePicture());
            	request.setAttribute("listTreeRequest", treeRequestDAO.listAllTreeRequest());
            	request.getRequestDispatcher("admin_dashboard.jsp").forward(request, response);
        		System.out.println("Database successfully initialized!");
        		break;
        	case "/logout":
        		logout(request,response);
        		break;
	    	}
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
        	
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 String username = request.getParameter("username");
	    	 String password = request.getParameter("password");
	    	 
	    	 if (username.equals("root") && password.equals("root1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", username);
				// rootPage(request, response, "");
	    	 }
	    	 else if(userDAO.isValid(username, password) != null) 
	    	 {
			 	 String role = userDAO.isValid(username, password);
			 	 currentUser = username;
				 System.out.println("Login Successful! Redirecting");
				 if ("David Smith".equals(role)) {
					 request.getRequestDispatcher("david_smith_dashboard.jsp").forward(request, response);
	                } else if ("Client".equals(role)) {
	                	request.getRequestDispatcher("client_dashboard.jsp").forward(request, response);
	                } else if  ("Admin Root".equals(role)) {
	                	request.setAttribute("listAdmin", adminDAO.listAllAdmins());
	                	request.setAttribute("listBillDetails", billDetailsDAO.listAllBillDetails());
	                	request.setAttribute("listClient", clientDAO.listAllClient());
	                	request.setAttribute("listOrderDetails", orderdetailsDAO.listAllOrderDetails());
	                	request.setAttribute("listQuote", quoteDAO.listAllQuote());
	                	request.setAttribute("listTreeInformation", treeInformationDAO.listAllTreeInformation());
	                	request.setAttribute("listTreePicture", treePictureDAO.listAllTreePicture());
	                	request.setAttribute("listTreeRequest", treeRequestDAO.listAllTreeRequest());
	                	request.getRequestDispatcher("admin_dashboard.jsp").forward(request, response);
	                }
			 			 			 			 
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String username = request.getParameter("username");
	   	 	String password = request.getParameter("password");
	   	 	String role = request.getParameter("role");	   	 	
	   	 	String confirm = request.getParameter("confirmation");
	   	 	
	   	 	if (password.equals(confirm)) {
	   	 		if (!userDAO.checkUsername(username)) {
		   	 		System.out.println("Registration Successful! Added to database");
		            user users = new user(username, password, role);
		            System.out.println(role);
		            if(role.equalsIgnoreCase("Admin Root")) {
		            	System.out.println("Inside admin root");
		            	long millis=System.currentTimeMillis();  
		            	admin admin = new admin(username,password,"Account created",new java.sql.Date(millis));
		            	adminDAO.insert(admin);
		            } 
		   	 		userDAO.insert(users);
		   	 		response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("Username taken, please enter new username");
		    		 request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   		 request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }    
	    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	}
	
	    

	     
        
	    
	    
	    
	    
	    
}
	        
	        
	    
	        
	        
	        
	    


