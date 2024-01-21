public class ListNode {
    private TableEntry value;
    private ListNode next;

    // Constructor to make a new node with both data and pointer
    public ListNode(TableEntry initValue, ListNode initNext) {
        value = initValue;
        next = initNext;
    }

    // Constructor to make a new node with a null pointer
    public ListNode(TableEntry initValue) {
        this(initValue, null);
    }

    // Sets the current value of the node to the value from the parameter
    public void setValue(TableEntry theNewValue) {
        value = theNewValue;
    }

    // Sets the pointer of the next node to the one from the parameter
    public void setNext(ListNode theNewNext) {
        next = theNewNext;
    }

    // Returns the value of the node
    public TableEntry getValue() {
        return value;
    }

    // Returns the pointer to the next node
    public ListNode getNext() {
        return next;
    }
}