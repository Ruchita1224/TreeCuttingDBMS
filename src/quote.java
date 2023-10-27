import java.util.Date;

public class quote {
    protected String quoteID;
    protected String requestID;
    protected Date quoteDate;
    protected double price;
    protected String timeWindow;
    protected String status;
    protected String note;

    public quote(String quoteID, String requestID, Date quoteDate, double price, String timeWindow, String status, String note) {
        this.quoteID = quoteID;
        this.requestID = requestID;
        this.quoteDate = quoteDate;
        this.price = price;
        this.timeWindow = timeWindow;
        this.status = status;
        this.note = note;
    }

    public String getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(String quoteID) {
        this.quoteID = quoteID;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public Date getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(Date quoteDate) {
        this.quoteDate = quoteDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTimeWindow() {
        return timeWindow;
    }

    public void setTimeWindow(String timeWindow) {
        this.timeWindow = timeWindow;
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
