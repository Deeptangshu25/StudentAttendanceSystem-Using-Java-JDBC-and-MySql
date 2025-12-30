import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Attendance {

    public void markAttendance(Scanner sc) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Status (P for Present / A for Absent): ");
            String input = sc.nextLine().trim().toUpperCase();

            String status;
            if (input.equals("P")) {
                status = "Present";
            } else if (input.equals("A")) {
                status = "Absent";
            } else {
                System.out.println("Invalid input! Please enter P or A.");
                con.close();
                return;
            }

            // Get today's date automatically
            LocalDate today = LocalDate.now();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO attendance(student_id, date, status) VALUES (?,?,?)"
            );
            ps.setInt(1, id);
            ps.setDate(2, Date.valueOf(today));
            ps.setString(3, status);

            ps.executeUpdate();
            System.out.println("Attendance Marked Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAttendance() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            String sql =
                "SELECT s.name, s.roll_no, a.date, a.status " +
                "FROM attendance a JOIN students s " +
                "ON a.student_id = s.student_id";

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n--- Attendance Records ---");
            while (rs.next()) {
                System.out.println(
                    rs.getString(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getDate(3) + " | " +
                    rs.getString(4)
                );
            }
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
