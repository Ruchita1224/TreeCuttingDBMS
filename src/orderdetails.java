import java.util.Date;

public class orderdetails {
    protected String orderID;
    protected String quoteID;
    protected Date orderDate;
    protected String status;

    public orderdetails(String orderID, String quoteID, Date orderDate, String status) {
        this.orderID = orderID;
        this.quoteID = quoteID;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(String quoteID) {
        this.quoteID = quoteID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
