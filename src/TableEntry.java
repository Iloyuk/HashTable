public class TableEntry {
    private String key; // last name
    private DataType data;

    // Constructor
    public TableEntry(String theKey, DataType theData) {
        key = theKey;
        data = theData;
    }

    // Returns the key of the table entry
    public String getKey() {
        return key;
    }

    public boolean equals(TableEntry obj) {
        return (key.equals(obj.getKey()) && data.equals(obj.data)); // ask whether this is OK
    }

    // toString method for TableEntry objects
    public String toString() {
        return "[" + key + ", " + data.toString() + "]";
    }
}


