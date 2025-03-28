package java_practice;

import java.sql.*;
import java.util.Scanner;

public class slip22_1 {
    // Database connection details (Modify as per your DB settings)
    static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;

        try {
            // Load JDBC Driver (for MySQL)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            while (true) {
                // Menu Display
                System.out.println("\n=== Employee Management System ===");
                System.out.println("1. Insert Employee");
                System.out.println("2. Update Employee Salary");
                System.out.println("3. Display Employees");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertEmployee(conn, scanner);
                        break;
                    case 2:
                        updateEmployee(conn, scanner);
                        break;
                    case 3:
                        displayEmployees(conn);
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        scanner.close();
                        conn.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to insert employee details
    public static void insertEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee Number: ");
        int eno = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String ename = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        String sql = "INSERT INTO Employee (ENo, EName, Salary) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, eno);
        pstmt.setString(2, ename);
        pstmt.setDouble(3, salary);

        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Employee inserted successfully!");
        }
    }

    // Method to update employee salary
    public static void updateEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee Number to update salary: ");
        int eno = scanner.nextInt();
        System.out.print("Enter new Salary: ");
        double newSalary = scanner.nextDouble();

        String sql = "UPDATE Employee SET Salary = ? WHERE ENo = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, newSalary);
        pstmt.setInt(2, eno);

        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Employee salary updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Method to display employee details
    public static void displayEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Employee";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n=== Employee Records ===");
        System.out.printf("%-10s %-20s %-10s\n", "Emp No", "Employee Name", "Salary");
        System.out.println("--------------------------------------------");

        while (rs.next()) {
            int eno = rs.getInt("ENo");
            String ename = rs.getString("EName");
            double salary = rs.getDouble("Salary");
            System.out.printf("%-10d %-20s %-10.2f\n", eno, ename, salary);
        }
    }
}
