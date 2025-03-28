package java_practice;

import java.sql.*;

public class slip29_1 {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace with your database name
        String user = "your_username"; // Replace with your database username
        String password = "your_password"; // Replace with your database password

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            conn = DriverManager.getConnection(url, user, password);

            // Create Statement
            stmt = conn.createStatement();

            // Execute Query to fetch metadata of DONAR table
            rs = stmt.executeQuery("SELECT * FROM DONAR LIMIT 1"); // Fetch only one row for metadata

            // Get ResultSetMetaData
            ResultSetMetaData metaData = rs.getMetaData();

            // Get Column Count
            int columnCount = metaData.getColumnCount();

            // Display Column Details
            System.out.println("Column Details of DONAR Table:");
            System.out.println("----------------------------------------");

            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println("Name      : " + metaData.getColumnName(i));
                System.out.println("Type      : " + metaData.getColumnTypeName(i));
                System.out.println("Size      : " + metaData.getColumnDisplaySize(i));
                System.out.println("Nullable  : " + (metaData.isNullable(i) == ResultSetMetaData.columnNullable ? "YES" : "NO"));
                System.out.println("----------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
