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

    // Returns true if this.key equals String (key) part of val
    public boolean equals(TableEntry val) {
        return key.equals(val.getKey());
    }

    // toString method for TableEntry objects
    public String toString() {
        return "[" + key + ", " + data.toString() + "]";
    }
}


