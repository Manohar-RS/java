<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Patient Details</title>
    <style>
         th, td { border: 1px solid black; padding: 10px; text-align: center; }
        th { background-color: green; color: white; }
       
        </style>
  <!--    <style>
        body { font-family: Arial, sans-serif; }
        table { width: 70%; border-collapse: collapse; margin: 20px auto; }
       
    </style>     <tr><td colspan='5' style='color:red; text-align:center;'>-->
</head>
<body>

<h2 style="text-align: center;">Patient Details</h2>
			
<table>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>email</th>
        <th>password</th>
        
    </tr>

    <%
        // Database Connection Details
        String DB_URL = "jdbc:mysql://localhost:3306/project1";
        String DB_USER = "root"; // Change if needed
        String DB_PASSWORD = "root"; // Change if needed

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC Driver
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user");

            while (rs.next()) {
    %>
                <tr>
                    <td><%= rs.getInt("id") %></td>
                    <td><%= rs.getString("username") %></td>
                    <td><%= rs.getString("email") %></td>
                    <td><%= rs.getInt("password") %></td>
                 
                </tr>
    <%
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage() + "</td></tr>");
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
    %>

</table>

</body>
</html>
