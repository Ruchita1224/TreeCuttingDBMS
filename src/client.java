public class client {
    protected String clientID;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String creditCardInfo;
    protected String phoneNumber;
    protected String email;

    public client(String clientID, String firstName, String lastName, String address, String creditCardInfo, String phoneNumber, String email) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.creditCardInfo = creditCardInfo;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
