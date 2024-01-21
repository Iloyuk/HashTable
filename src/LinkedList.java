public class LinkedList {
    private ListNode first;

    // Default Constructor
    public LinkedList() {
        first = null;	// first is the external pointer
    }

    // Determines if the list is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Adds value at front of list
    public void addAtFront(TableEntry value) {
        first = new ListNode(value, first);
    }

    // Adds value at back of list
    public void addAtBack(TableEntry value) {
        if (isEmpty())
            addAtFront(value);
        else {
            ListNode current = first;

            while (current.getNext() != null)
                current = current.getNext();

            current.setNext(new ListNode(value));
        }
    }

    // Prints the list in sequential order
    public void print() {
        if (isEmpty())
            System.out.println("\\");
        else
        {
            ListNode current = first;
            while (current != null)
            {
                System.out.print(current.getValue() + " -> ");
                current = current.getNext();
            }
            System.out.println("\\");
        }

    }

    // Deletes all occurrences of value in the list
    public void delete(Object value) {
        ListNode current = first;
        boolean done = false;

        if (current.getValue().getKey().equals(value)) { // Check for first node
            // If the only value in the list is the value that matches
            if (current.getNext() == null)
                first = null;
            else { // If value exists in first node but list has multiple nodes
                ListNode temp = first.getNext();

                // Checks for consecutive matching values
                while (temp != null && temp.getValue().getKey().equals(value))
                    temp = temp.getNext();

                first = temp;

                // Accounts for if all nodes in the list have the same value
                if (first == null)
                    return; // Early return so there won't be a null pointer
            }
        }

        // Check for other nodes
        while (!done && current.getNext() != null) {
            if (current.getNext().getValue().getKey().equals(value)) {
                ListNode temp = current.getNext();

                // Checks for consecutive matching values
                while (temp != null && temp.getValue().getKey().equals(value))
                    temp = temp.getNext();

                current.setNext(temp);
            }

            current = current.getNext();
            if (current == null) // If iterator goes past last node
                done = true; // Short circuits to prevent null pointer
        }
    }

    // Returns the size of the list
    public int size() {
        ListNode current = first;
        int counter = 1;

        if (isEmpty()) // Accounts for empty list
            return 0;

        while (current.getNext() != null) {
            current = current.getNext();
            counter++;
        }

        return counter;
    }

    // Clears entire list
    public void clear() {
        first = null;
    }

    // Returns true if value is in the list; otherwise returns false
    public boolean find(Object value) {
        ListNode current = first;

        // If the first node in the list is the value
        if (first.getValue().getKey().equals(value))
            return true;

        while (current.getNext() != null) {
            if (current.getNext().getValue().getKey().equals(value))
                return true;
            current = current.getNext();
        }
        return false;
    }

}
