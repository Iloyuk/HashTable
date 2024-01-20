public class DataType {
    private String firstName;
    private double gpa;

    // Constructor
    public DataType(String theName, double thegpa) {
        firstName = theName;
        gpa = thegpa;
    }

    // Get method for firstName
    public String getName() {
        return firstName;
    }

    // toString method for DataType objects
    public String toString() {
        return firstName + ", " + gpa;
    }
}
