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
    public void addAtFront(Object value) {
        first = new ListNode(value, first);
    }

    // Adds value at back of list
    public void addAtBack(Object value) {
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

        if (((TableEntry)current.getValue()).getKey().equals(value)) { // Check for first node
            // If the only value in the list is the value that matches
            if (current.getNext() == null)
                first = null;
            else { // If value exists in first node but list has multiple nodes
                ListNode temp = first.getNext();

                // Checks for consecutive matching values
                while (temp != null && ((TableEntry)temp.getValue()).getKey().equals(value))
                    temp = temp.getNext();

                first = temp;

                // Accounts for if all nodes in the list have the same value
                if (first == null)
                    return; // Early return so there won't be a null pointer
            }
        }

        // Check for other nodes
        while (!done && current.getNext() != null) {
            if (((TableEntry)(current.getNext().getValue())).getKey().equals(value)) {
                ListNode temp = current.getNext();

                // Checks for consecutive matching values
                while (temp != null && ((TableEntry)temp.getValue()).getKey().equals(value))
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

    // Inserts a value at position in the list; pos ranges from 1 to size() + 1
    public void insertPos(Object value, int pos) {

        if (pos == 1)
            addAtFront(value);
        else if (pos == size() + 1)
            addAtBack(value);
        else {
            ListNode current = first;
            int counter = 1;

            do {
                if (counter + 1 == pos)
                    current.setNext(new ListNode(value, current.getNext()));
                else
                    current = current.getNext();

                counter++;
            } while (counter + 1 <= pos);
        }
    }

    // Inserts a value into the list before the search value
    public void insert(Object value, int search_value) {
        ListNode current = first;
        ListNode hold = null;
        boolean isFirst = false;

        if (first.getValue().equals(search_value)) { // Check for first node
            hold = first;
            isFirst = true;
        }

        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(search_value)) {
                // Holds the pointer to the node one before the search value
                hold = current;
                isFirst = false;
            }

            current = current.getNext();
        }

        // Special case for if search value is still on the first node
        if (isFirst)
            addAtFront(value);
        else {
            assert hold != null;
            hold.setNext(new ListNode(value, hold.getNext()));
        }
    }

    // Returns element of the last node in the list
    public int getLast() {
        ListNode current = first;

        while (current.getNext() != null)
            current = current.getNext();

        return (int)current.getValue();
    }

    // Clears entire list
    public void clear() {
        first = null;
    }

    // Returns true if value is in the list; otherwise returns false
    public boolean find(Object value) {
        ListNode current = first;

        // If the first node in the list is the value
        if (first.getValue().equals(value))
            return true;

        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value))
                return true;
            current = current.getNext();
        }
        return false;
    }

    // Removes all extraneous duplicate values
    public void removeDuplicates() {
        // Deletes duplicate values for the first element
        int value = (int)first.getValue();
        delete(value);
        addAtFront(value);

        ListNode current = first;
        int counter = 2; // Tracker to see what position in the list we're in

        while (current.getNext() != null) {
            value = (int)current.getNext().getValue();
            delete(value);
            insertPos(value, counter);

            current = current.getNext();
            counter++;
        }

    }

    // Prints the list backwards
    public void printBackwards() {
        if (isEmpty()) {
            print();
            return;
        }

        printBack(first);
        System.out.println();
    }

    // Helper method for recursively printing the list
    private void printBack(ListNode current) {
        if (current.getNext() != null)
            printBack(current.getNext());

        System.out.print(current.getValue() + " ");
    }
}
