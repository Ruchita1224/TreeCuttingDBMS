import java.util.List;

public class clientSummary {
    private String clientID;
    private String firstName;
    private String lastName;
    private int totalTrees;
    private double totalDueAmount;
    private double totalPaidAmount;
    private List<String> workDoneDates;

    // Constructors

    public clientSummary() {
        // Default constructor
    }

    public clientSummary(String clientID, String firstName, String lastName, int totalTrees,
                         double totalDueAmount, double totalPaidAmount, List<String> workDoneDates) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalTrees = totalTrees;
        this.totalDueAmount = totalDueAmount;
        this.totalPaidAmount = totalPaidAmount;
        this.workDoneDates = workDoneDates;
    }

    // Getters

    public String getClientID() {
        return clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTotalTrees() {
        return totalTrees;
    }

    public double getTotalDueAmount() {
        return totalDueAmount;
    }

    public double getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public List<String> getWorkDoneDates() {
        return workDoneDates;
    }

    // Setters

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTotalTrees(int totalTrees) {
        this.totalTrees = totalTrees;
    }

    public void setTotalDueAmount(double totalDueAmount) {
        this.totalDueAmount = totalDueAmount;
    }

    public void setTotalPaidAmount(double totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public void setWorkDoneDates(List<String> workDoneDates) {
        this.workDoneDates = workDoneDates;
    }
}
