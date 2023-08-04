import java.util.*;

public class StudentManagementSystem {

    List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student Added Successfully");
    }

    
    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student Details :");
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Department: " + student.getDept());
                return;
            }
        }
        System.out.println("No Student available with Roll Number: " + rollNumber);
    }

    public void removeStudent(int rollNumber) {
        boolean r = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getRollNumber() == rollNumber) {
                students.remove(i);
                r = true;
                System.out.println("Student Removed Successfully");
                break;
            }
        }
        if (!r) {
            System.out.println("No Student available with Roll Number: " + rollNumber);
        }
    }


    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No Records found!!List is Empty");
        } else {
            System.out.println("Student Records:");
            for (Student student : students) {
                System.out.println("\n");
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Department: " + student.getDept());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("1. Add New Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Find a Student");
            System.out.println("4. All Student Details");
            System.out.println("5. Exit Application");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Student Roll Number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Department: ");
                    String grade = sc.nextLine();

                    Student student = new Student(name, rollNumber, grade);
                    sms.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter Roll Number of Student : ");
                    int removeRollNumber = sc.nextInt();
                    sc.nextLine();

                    sms.removeStudent(removeRollNumber);
                    break;

                case 3:
                    System.out.print("Enter Roll Number of Student : ");
                    int searchRollNumber = sc.nextInt();
                    sc.nextLine();

                    sms.searchStudent(searchRollNumber);
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Thank You for using Student Management System");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
