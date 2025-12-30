import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // ONLY Scanner

        UserLogin login = new UserLogin();
        if (!login.login(sc)) {
            System.out.println("Authentication failed. Exiting system...");
            return;
        }

        Student student = new Student();
        Attendance attendance = new Attendance();

        while (true) {
            System.out.println("\n===== Student Attendance System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Mark Attendance");
            System.out.println("5. View Attendance");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    student.addStudent(sc);
                    break;
                case 2:
                    student.viewStudents();
                    break;
                case 3:
                    student.deleteStudent(sc);
                    break;
                case 4:
                    attendance.markAttendance(sc);
                    break;
                case 5:
                    attendance.viewAttendance();
                    break;
                case 6:
                    System.out.println("Logging out and exiting system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
