public class ListNode {
    private Object value;
    private ListNode next;

    // Constructor to make a new node with both data and pointer
    public ListNode(Object initValue, ListNode initNext) {
        value = initValue;
        next = initNext;
    }

    // Constructor to make a new node with a null pointer
    public ListNode(Object initValue) {
        this(initValue, null);
    }

    // Sets the current value of the node to the value from the parameter
    public void setValue(Object theNewValue) {
        value = theNewValue;
    }

    // Sets the pointer of the next node to the one from the parameter
    public void setNext(ListNode theNewNext) {
        next = theNewNext;
    }

    // Returns the value of the node
    public Object getValue() {
        return value;
    }

    // Returns the pointer to the next node
    public ListNode getNext() {
        return next;
    }
}