import java.util.Date;

public class billDetails {
    protected String billID;
    protected String orderID;
    protected Date billedDate;
    protected double amount;
    protected String status;
    protected String note;

    public billDetails(String billID, String orderID, Date billedDate, double amount, String status, String note) {
        this.billID = billID;
        this.orderID = orderID;
        this.billedDate = billedDate;
        this.amount = amount;
        this.status = status;
        this.note = note;
    }
    
    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getBilledDate() {
        return billedDate;
    }

    public void setBilledDate(Date billedDate) {
        this.billedDate = billedDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
