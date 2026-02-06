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
        System.out.println("\n========== ALL STUDENTS ==========");
        if (studentCount == 0) {
            System.out.println("No students registered yet.");
            return;
        }
        for (int i = 0; i < studentCount; i++) {
            System.out.println((i + 1) + ". Name: " + students[i].getName() + 
                ", Registration: " + students[i].getRegistrationNumber() + 
                ", Books Borrowed: " + students[i].getBookCount());
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