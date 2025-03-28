package java_practice;

import java.sql.*;

public class slip16_2 {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/manohardb"; // Change "your_database"
        String user = "root"; // Change as per your MySQL username
        String password = "root"; // Change as per your MySQL password

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Step 1: Create the Teacher Table (if not exists)
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Teacher ("
                    + "TNo INT PRIMARY KEY, "
                    + "TName VARCHAR(50), "
                    + "Subject VARCHAR(50))";
            PreparedStatement createStmt = conn.prepareStatement(createTableSQL);
            createStmt.executeUpdate();

            // Step 2: Insert records into the Teacher table
            String insertSQL = "INSERT INTO Teacher (TNo, TName, Subject) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);

            // Adding 5 records
            insertStmt.setInt(1, 101);
            insertStmt.setString(2, "Alice");
            insertStmt.setString(3, "JAVA");
            insertStmt.executeUpdate();

            insertStmt.setInt(1, 102);
            insertStmt.setString(2, "Bob");
            insertStmt.setString(3, "Python");
            insertStmt.executeUpdate();

            insertStmt.setInt(1, 103);
            insertStmt.setString(2, "Charlie");
            insertStmt.setString(3, "JAVA");
            insertStmt.executeUpdate();

            insertStmt.setInt(1, 104);
            insertStmt.setString(2, "David");
            insertStmt.setString(3, "C++");
            insertStmt.executeUpdate();

            insertStmt.setInt(1, 105);
            insertStmt.setString(2, "Emma");
            insertStmt.setString(3, "JAVA");
            insertStmt.executeUpdate();

            // Step 3: Retrieve and display teachers who teach JAVA
            String selectSQL = "SELECT * FROM Teacher WHERE Subject = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
            selectStmt.setString(1, "JAVA");

            ResultSet rs = selectStmt.executeQuery();

            System.out.println("Teachers teaching JAVA:");
            System.out.println("-----------------------------");
            while (rs.next()) {
                System.out.println("TNo: " + rs.getInt("TNo") +
                        ", Name: " + rs.getString("TName") +
                        ", Subject: " + rs.getString("Subject"));
            }

            // Close resources
            createStmt.close();
            insertStmt.close();
            selectStmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

