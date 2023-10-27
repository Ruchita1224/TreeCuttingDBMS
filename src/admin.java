import java.util.Date;

public class admin {
    protected String loginID;
    protected String actionPerformed;
    protected Date timestamp;
    protected String password;
    public admin() {
    	
    }
    
    public admin(String loginID, String password, String actionPerformed , Date timestamp) {
    	this.loginID = loginID;
    	this.password = password;
    	this.actionPerformed = actionPerformed;
    	this.timestamp = timestamp;
    }
    // Getters and setters for the above fields
    public String getLoginID() {
        return loginID;
    }
    
    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }

    public String getActionPerformed() {
        return actionPerformed;
    }

    public void setActionPerformed(String actionPerformed) {
        this.actionPerformed = actionPerformed;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
