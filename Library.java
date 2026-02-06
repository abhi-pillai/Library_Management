package Library_Management;

import java.util.Scanner;

public class Library {
    private Books books;
    private Students students;
    private Scanner sc;

    public Library() {
        this.books = new Books();
        this.students = new Students();
        this.sc = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
        System.out.println("1. Add Book");
        System.out.println("2. Register Student");
        System.out.println("3. Show All Books");
        System.out.println("4. Search Book");
        System.out.println("5. Checkout Book");
        System.out.println("6. Checkin Book");
        System.out.println("7. List All Students");
        System.out.println("8. Exit");
        System.out.println("===============================================");
        System.out.print("Enter your choice: ");
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    registerStudent();
                    break;
                case 3:
                    books.showAllBooks();
                    System.out.println("===============================================");
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    checkoutBook();
                    break;
                case 6:
                    checkinBook();
                    break;
                case 7:
                    students.listAllStudents();
                    System.out.println("===============================================");
                    break;
                case 8:
                    System.out.println("Thank you for using Library Management System!");
                    System.out.println("===============================================\n\n");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    System.out.println("===============================================");
            }
        } while (choice != 8);

        sc.close();
    }

    private void addBook() {
        // Pass the Scanner to Book constructor - FIXED
        Book book = new Book(sc);
        books.addBook(book);
        System.out.println("Book added successfully!");
        System.out.println("===============================================");
    }

    private void registerStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Registration Number: ");
        String regNo = sc.nextLine();

        if (students.addStudent(name, regNo)) {
            System.out.println("Student registered successfully!");
        } else {
            System.out.println("Failed to register student. Registration number already exists or list is full.");
        }
        System.out.println("===============================================");
    }

    private void searchBook() {
        System.out.println("\n1. Search by Serial Number");
        System.out.println("2. Search by Book Name");
        System.out.print("Enter search option: ");
        int searchChoice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (searchChoice) {
            case 1:
                books.searchBySno();
                break;
            case 2:
                books.searchByName();
                break;
            default:
                System.out.println("Invalid search option!");
        }
            System.out.println("===============================================");
    }

    private void checkoutBook() {
        System.out.print("Enter Student Registration Number: ");
        String regNo = sc.nextLine();
        
        Book book = books.checkOutBook();
        if (book != null) {
            if (students.borrowBook(regNo, book.getBookName())) {
                System.out.println("Book checked out successfully!");
            } else {
                // Return the book if student cannot borrow
                books.checkInBook(book);
                System.out.println("Student cannot borrow more books or student not found.");
            }
        } else {
            System.out.println("Book not available or not found.");
        }
        System.out.println("===============================================");
    }

    private void checkinBook() {
        System.out.print("Enter Student Registration Number: ");
        String regNo = sc.nextLine();
        System.out.print("Enter Book Title: ");
        String bookTitle = sc.nextLine();

        if (students.returnBook(regNo, bookTitle)) {
            // Create a dummy book object to return - this needs improvement
            System.out.println("Book checked in successfully!");
        } else {
            System.out.println("Failed to check in book. Student or book not found.");
        }
        System.out.println("===============================================");
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.run();
    }
}