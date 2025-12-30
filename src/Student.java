import java.sql.*;
import java.util.Scanner;

public class Student {

    public void addStudent(Scanner sc) {
    try {
        Connection con = DBConnection.getConnection();

        // Find next available ID
        int nextId = 1;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT MIN(t1.student_id + 1) AS next_id " +
            "FROM students t1 LEFT JOIN students t2 " +
            "ON t1.student_id + 1 = t2.student_id " +
            "WHERE t2.student_id IS NULL"
        );

        if (rs.next() && rs.getInt("next_id") != 0) {
            nextId = rs.getInt("next_id");
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll No: ");
        String roll = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO students(student_id, name, roll_no, course) VALUES (?,?,?,?)"
        );
        ps.setInt(1, nextId);
        ps.setString(2, name);
        ps.setString(3, roll);
        ps.setString(4, course);

        ps.executeUpdate();
        System.out.println("Student Added Successfully with ID: " + nextId);

        con.close();

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}


    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("student_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("roll_no") + " | " +
                    rs.getString("course")
                );
            }
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteStudent(Scanner sc) {
    try {
        Connection con = DBConnection.getConnection();

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM students WHERE student_id=?"
        );
        ps.setInt(1, id);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Student not found! No record with this ID.");
        }

        con.close();

        } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        }
    }
}
