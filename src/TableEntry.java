public class TableEntry {
    private String key; // last name
    private DataType data;

    public TableEntry(String theKey, DataType theData) {
        key = theKey;
        data = theData;
    }

    // Returns the key of the table entry
    public String getKey() {
        return key;
    }

    // toString method for TableEntry class
    public String toString() {
        return "" + key + " " + data;
    }
}
