package Library_Management;

public class Students {
    private Student[] students;
    private int studentCount;

    public Students() {
        this.students = new Student[100];
        this.studentCount = 0;
    }

    public boolean addStudent(String name, String registrationNumber) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getRegistrationNumber().equals(registrationNumber)) {
                return false;
            }
        }
        if (studentCount < students.length) {
            students[studentCount] = new Student(name, registrationNumber);
            studentCount++;
            return true;
        }
        return false;
    }

    private Student findStudent(String registrationNumber) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getRegistrationNumber().equals(registrationNumber)) {
                return students[i];
            }
        }
        return null;
    }

    public void listAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students registered yet.");
            return;
        }
        else{
               System.out.println("\n========== ALL STUDENTS ==========");
               System.out.printf("%-5s %-25s %-20s %-15s%n",
        "No.", "Name", "Registration No", "Books Borrowed");

System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-5d %-25s %-20s %-15d%n",
                (i + 1),
                students[i].getName(),
                students[i].getRegistrationNumber(),
                students[i].getBookCount()
            );
        }
        
    }
    }

    public boolean borrowBook(String registrationNumber, String bookTitle) {
        Student student = findStudent(registrationNumber);
        if (student != null) {
            return student.borrowBook(bookTitle);
        }
        return false;
    }

    public boolean returnBook(String registrationNumber, String bookTitle) {
        Student student = findStudent(registrationNumber);
        if (student != null) {
            return student.returnBook(bookTitle);
        }
        return false;
    }
}