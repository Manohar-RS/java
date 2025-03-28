package java_practice;

import java.sql.*;

public class slip27_1 {
    public static void main(String[] args) {
        // Database credentials (update accordingly)
        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace 'your_database' with actual DB name
        String user = "root";  // Replace with your database username
        String password = "";  // Replace with your database password

        // SQL Query
        String query = "SELECT * FROM College"; // Assuming 'College' is the table name

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            // Display Header
            System.out.println("+------+----------------+----------------------+------");
            System.out.printf("| %-4s | %-14s | %-20s | %-4s |\n", "CID", "CName", "Address", "Year");
            System.out.println("+------+----------------+----------------------+------");

            // Display Records
            while (rs.next()) {
                int cid = rs.getInt("CID");
                String cname = rs.getString("CName");
                String address = rs.getString("Address");
                int year = rs.getInt("Year");

                System.out.printf("| %-4d | %-14s | %-20s | %-4d |\n", cid, cname, address, year);
            }
            System.out.println("+------+----------------+----------------------+------");

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
