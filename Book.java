package Library_Management;

public class Book {

    private int serialNumber;
    private String bookName;
    private String authorName;
    private int totalQuantity;
    private int availableQuantity;

    // Constructor with Scanner parameter - FIXED
    public Book(java.util.Scanner sc) {
        System.out.print("Enter Serial Number: ");
        this.serialNumber = sc.nextInt();
        sc.nextLine(); // consume newline
        
        System.out.print("Enter Book Name: ");
        this.bookName = sc.nextLine();
        
        System.out.print("Enter Author Name: ");
        this.authorName = sc.nextLine();
        
        System.out.print("Enter Total Quantity: ");
        this.totalQuantity = sc.nextInt();
        
        System.out.print("Enter Available Quantity: ");
        this.availableQuantity = sc.nextInt();
        sc.nextLine(); // consume newline
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}