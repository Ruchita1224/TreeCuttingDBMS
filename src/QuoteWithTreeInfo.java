import java.util.Date;

public class QuoteWithTreeInfo {

	private String quoteID;
    private String requestID;
    private Date quoteDate;
    private double price;
    private String timeWindow;
    private String status;
    private String note;
    private String treeinfoID;
    private double size;
    private double height;
    private String location;
    private String nearHouse;
    private String pictureURL;

    public QuoteWithTreeInfo(String quoteID, String requestID, Date quoteDate, double price, String timeWindow, String status, String note,
                             String treeinfoID, double size, double height, String location, String nearHouse, String pictureURL) {
        this.quoteID = quoteID;
        this.requestID = requestID;
        this.quoteDate = quoteDate;
        this.price = price;
        this.timeWindow = timeWindow;
        this.status = status;
        this.note = note;
        this.treeinfoID = treeinfoID;
        this.size = size;
        this.height = height;
        this.location = location;
        this.nearHouse = nearHouse;
        this.pictureURL = pictureURL;
    }

    // Getters and setters for all fields go here

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

	public String getTreeinfoID() {
		return treeinfoID;
	}

	public void setTreeinfoID(String treeinfoID) {
		this.treeinfoID = treeinfoID;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNearHouse() {
		return nearHouse;
	}

	public void setNearHouse(String nearHouse) {
		this.nearHouse = nearHouse;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}


    @Override
    public String toString() {
        return "QuoteWithTreeInfo{" +
                "quoteID='" + quoteID + '\'' +
                ", requestID='" + requestID + '\'' +
                ", quoteDate=" + quoteDate +
                ", price=" + price +
                ", timeWindow='" + timeWindow + '\'' +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", treeinfoID='" + treeinfoID + '\'' +
                ", size='" + size + '\'' +
                ", height='" + height + '\'' +
                ", location='" + location + '\'' +
                ", nearHouse='" + nearHouse + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                '}';
    }
}
