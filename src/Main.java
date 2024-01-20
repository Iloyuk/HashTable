import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, key;
        double gpa;

        System.out.print("Please enter the amount of buckets you would like for your hash table: ");
        HashTable table = new HashTable(sc.nextInt());

        int choice;
        do {
            System.out.print("Enter 1 to add a new table entry, 2 to delete all entries of a certain key, 3 to print " +
                    "the hash table, or 4 to quit the program: ");
            choice = Integer.parseInt(sc.next());

            switch (choice) {
                case 1:
                    System.out.print("Please enter the key, or last name, of the student you wish to store: ");
                    key = sc.next();
                    System.out.print("Please enter the first name of the student you wish to store: ");
                    name = sc.next();
                    System.out.print("Please enter the GPA of the student you wish to store: ");
                    gpa = Double.parseDouble(sc.next());

                    table.insert(key, new DataType(name, gpa));
                    break;
                case 2:
                    System.out.print("Please enter the key, or last name, that you wish to delete: ");
                    key = sc.next();
                    table.delete(key);
                    System.out.println("All entries with the key \"" + key + "\" have been deleted.");
                    break;
                case 3:
                    table.printTable();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("That is not one of the options.");

            }
        } while (choice != 4);

    }
}