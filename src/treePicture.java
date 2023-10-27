public class treePicture {
    protected String pictureID;
    protected String pictureURL;
    protected String treeInfoID;

    public treePicture(String pictureID, String pictureURL, String treeInfoID) {
        this.pictureID = pictureID;
        this.pictureURL = pictureURL;
        this.treeInfoID = treeInfoID;
    }

    public String getPictureID() {
        return pictureID;
    }

    public void setPictureID(String pictureID) {
        this.pictureID = pictureID;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getTreeInfoID() {
        return treeInfoID;
    }

    public void setTreeInfoID(String treeInfoID) {
        this.treeInfoID = treeInfoID;
    }
}
