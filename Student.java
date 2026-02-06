package Library_Management;

public class Student {
    
    private String name;
    private String registrationNumber;
    private String[] borrowedBooks;
    private int bookCount;
    
    public Student(String name, String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.borrowedBooks = new String[3];
        this.bookCount = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    
    public String[] getBorrowedBooks() {
        return borrowedBooks;
    }
    
    public int getBookCount() {
        return bookCount;
    }
    
    public boolean borrowBook(String bookTitle) {
        if (bookCount < 3) {
            borrowedBooks[bookCount] = bookTitle;
            bookCount++;
            return true;
        }
        return false;
    }
    
    public boolean returnBook(String bookTitle) {
        for (int i = 0; i < bookCount; i++) {
            if (borrowedBooks[i].equals(bookTitle)) {
                borrowedBooks[i] = borrowedBooks[bookCount - 1];
                borrowedBooks[bookCount - 1] = null;
                bookCount--;
                return true;
            }
        }
        return false;
    }
}