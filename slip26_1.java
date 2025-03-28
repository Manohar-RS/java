package java_practice;

import java.sql.*;

public class slip26_1 {
    public static void main(String[] args) {
        // Check if Employee ID is provided
        if (args.length != 1) {
            System.out.println("Usage: java DeleteEmployee <Employee_ID>");
            return;
        }

        int empId = Integer.parseInt(args[0]); // Convert command-line argument to integer

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database"; // Change database name
        String user = "root";  // Change username
        String password = "";  // Change password

        // SQL Query to delete the employee
        String deleteQuery = "DELETE FROM Employee WHERE ENo = ?";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery)
        ) {
            // Set parameter for prepared statement
            pstmt.setInt(1, empId);

            // Execute update
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + empId + " deleted successfully.");
            } else {
                System.out.println("No Employee found with ID " + empId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
