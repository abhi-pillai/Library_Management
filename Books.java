package Library_Management;

public class Books {
    private Book[] theBooks = new Book[50];
    private static int count = 0;
    private java.util.Scanner sc = new java.util.Scanner(System.in);

    public int compareBookObjects(Book b1, Book b2) {
        if (b1.getBookName().equalsIgnoreCase(b2.getBookName())) {
            System.out.println("Book of this Name Already Exists.");
            return 0;
        }
        if (b1.getSerialNumber() == b2.getSerialNumber()) {
            System.out.println("Book of this Serial No Already Exists.");
            return 0;
        }
        return 1;
    }

    public void addBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (this.compareBookObjects(b, this.theBooks[i]) == 0)
                return;
        }
        if (count < 50) {
            theBooks[count] = b;
            count++;
        } else {
            System.out.println("No Space to Add More Books.");
        }
    }

    public void searchBySno() {
        System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");
        System.out.print("Enter Serial No of Book: ");
        int sNo = sc.nextInt();
        sc.nextLine(); // consume newline
        
        System.out.printf("%-5s %-20s %-20s %-15s %-10s%n",
        "S.No", "Name", "Author", "Available Qty", "Total Qty");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].getSerialNumber()) {
                System.out.printf("%-5d %-20s %-20s %-15d %-10d%n",
                    theBooks[i].getSerialNumber(),
                    theBooks[i].getBookName(),
                    theBooks[i].getAuthorName(),
                    theBooks[i].getAvailableQuantity(),
                    theBooks[i].getTotalQuantity()
                );
                return;
            }
        }
            System.out.println("No Book for Serial No " + sNo + " Found.");
    }

    public void showAllBooks() {
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.printf("%-5s %-20s %-20s %-15s %-10s%n",
        "S.No", "Name", "Author", "Available Qty", "Total Qty");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d %-20s %-20s %-15d %-10d%n",
                theBooks[i].getSerialNumber(),
                theBooks[i].getBookName(),
                theBooks[i].getAuthorName(),
                theBooks[i].getAvailableQuantity(),
                theBooks[i].getTotalQuantity()
            );
        }
    }

    public Book checkOutBook() {
        System.out.print("Enter Serial No of Book to be Checked Out: ");
        int sNo = sc.nextInt();
        sc.nextLine(); // consume newline
        
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].getSerialNumber() && theBooks[i].getAvailableQuantity() > 0) {
                theBooks[i].setAvailableQuantity(theBooks[i].getAvailableQuantity() - 1);
                return theBooks[i];
            }
        }
        System.out.println("Book not found or not available.");
        return null;
    }

    public void checkInBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (b.getSerialNumber() == theBooks[i].getSerialNumber()) {
                theBooks[i].setAvailableQuantity(theBooks[i].getAvailableQuantity() + 1);
                return;
            }
        }
    }
    public void searchByName() {
        System.out.println("\t\t\t\tSEARCH BY BOOK NAME\n");
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();
        
        System.out.printf("%-5s %-20s %-20s %-15s %-10s%n",
        "S.No", "Name", "Author", "Available Qty", "Total Qty");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            if (name.equalsIgnoreCase(theBooks[i].getBookName())) {
                System.out.printf("%-5d %-20s %-20s %-15d %-10d%n",
                    theBooks[i].getSerialNumber(),
                    theBooks[i].getBookName(),
                    theBooks[i].getAuthorName(),
                    theBooks[i].getAvailableQuantity(),
                    theBooks[i].getTotalQuantity()
                    );
                return;
            }
        }
        System.out.println("No Book with Name " + name + " Found.");
    }
}