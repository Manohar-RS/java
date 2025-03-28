package java_practice;

import java.sql.*;

public class slip11_2 {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/project1"; // Change 'your_database'
        String user = "root"; // Change if necessary
        String password = "root"; // Change if necessary

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Create SQL Query
            String query = "SELECT * FROM user";
            PreparedStatement ps = con.prepareStatement(query);

            // Execute query and get metadata
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            // Get number of columns
            int columnCount = rsmd.getColumnCount();

            // Display column details
            System.out.println("Column Details of DONAR Table:");
            System.out.println("------------------------------------");

            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ": " + rsmd.getColumnName(i));
                System.out.println("   Type: " + rsmd.getColumnTypeName(i));
                System.out.println("   Size: " + rsmd.getColumnDisplaySize(i));
                System.out.println("------------------------------------");
            }

            // Close resources
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
