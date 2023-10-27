import java.util.Date;

public class treeRequest {
    protected String requestID;
    protected String clientID;
    protected Date requestDate;
    protected String status;
    protected String note;

    public treeRequest(String requestID, String clientID, Date requestDate, String status, String note) {
        this.requestID = requestID;
        this.clientID = clientID;
        this.requestDate = requestDate;
        this.status = status;
        this.note = note;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
