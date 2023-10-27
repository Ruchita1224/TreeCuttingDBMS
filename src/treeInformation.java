public class treeInformation {
    protected String treeInfoID;
    protected String requestID;
    protected double size;
    protected double height;
    protected String location;
    protected boolean nearHouse;

    public treeInformation(String treeInfoID, String requestID, double size, double height, String location, boolean nearHouse) {
        this.treeInfoID = treeInfoID;
        this.requestID = requestID;
        this.size = size;
        this.height = height;
        this.location = location;
        this.nearHouse = nearHouse;
    }

    public String getTreeInfoID() {
        return treeInfoID;
    }

    public void setTreeInfoID(String treeInfoID) {
        this.treeInfoID = treeInfoID;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
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

    public boolean isNearHouse() {
        return nearHouse;
    }

    public void setNearHouse(boolean nearHouse) {
        this.nearHouse = nearHouse;
    }
}
