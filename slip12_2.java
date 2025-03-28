package java_practice;

import java.sql.*;

public class slip12_2 {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/manohardb"; // Change to your database
        String user = "root"; // Change username if necessary
        String password = "root"; // Change password if necessary

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            // Step 1: Create PROJECT Table (If not exists)
            String createTableQuery = "CREATE TABLE IF NOT EXISTS PROJECT ("
                    + "project_id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "Project_name VARCHAR(100), "
                    + "Project_description TEXT, "
                    + "Project_Status VARCHAR(20))";
            stmt.executeUpdate(createTableQuery);

            // Step 2: Insert Sample Data (Skipping if already inserted)
            String insertDataQuery = "INSERT INTO PROJECT (Project_name, Project_description, Project_Status) VALUES "
                    + "('AI System', 'AI-based recommendation system', 'In Progress'),"
                    + "('E-Commerce', 'Online shopping platform', 'Completed'),"
                    + "('Banking App', 'Secure banking application', 'Pending')";
            stmt.executeUpdate(insertDataQuery);

            // Step 3: Retrieve and Display Data in Tabular Format
            String selectQuery = "SELECT * FROM PROJECT";
            ResultSet rs = stmt.executeQuery(selectQuery);

            // Display table headers
            System.out.println("+------------+-----------------+-----------------------------+---------------+");
            System.out.printf("| %-10s | %-15s | %-27s | %-13s |\n", "Project ID", "Project Name", "Project Description", "Status");
            System.out.println("+------------+-----------------+-----------------------------+---------------+");

            // Print each record in tabular format
            while (rs.next()) {
                System.out.printf("| %-10d | %-15s | %-27s | %-13s |\n",
                        rs.getInt("project_id"),
                        rs.getString("Project_name"),
                        rs.getString("Project_description"),
                        rs.getString("Project_Status"));
            }

            System.out.println("+------------+-----------------+-----------------------------+---------------+");

            // Close connections
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
