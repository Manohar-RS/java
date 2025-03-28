package java_practice;
import java.sql.*;

public class slip13_1 {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/manohardb"; // Change database name
        String user = "root";  // Change username if needed
        String password = "root"; // Change password if needed

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Get DatabaseMetaData
            DatabaseMetaData dbMetaData = con.getMetaData();

            // Display Database Information
            System.out.println("===== DATABASE INFORMATION =====");
            System.out.println("Database Name: " + dbMetaData.getDatabaseProductName());
            System.out.println("Database Version: " + dbMetaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbMetaData.getDriverName());
            System.out.println("Driver Version: " + dbMetaData.getDriverVersion());
            System.out.println("URL: " + dbMetaData.getURL());
            System.out.println("User Name: " + dbMetaData.getUserName());

            // Retrieve and List All Tables
            System.out.println("\n===== LIST OF TABLES =====");
            ResultSet tables = dbMetaData.getTables(null, null, "%", new String[]{"TABLE"});
            
            while (tables.next()) {
                System.out.println("Table Name: " + tables.getString("TABLE_NAME"));
            }

            // Close connections
            tables.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
