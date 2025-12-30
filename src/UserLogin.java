import java.sql.*;
import java.util.Scanner;

public class UserLogin {

    public boolean login(Scanner sc) {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful!");
                return true;
            } else {
                System.out.println("Invalid Username or Password!");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Login Error: " + e.getMessage());
            return false;
        }
    }
}
