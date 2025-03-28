<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Voter Eligibility Check</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .eligible {
            color: green;
            font-weight: bold;
        }
        .not-eligible {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <h2>Voter Eligibility Check</h2>
    
    <form method="post">
        <label>Enter Name:</label>
        <input type="text" name="name" required>
        <br><br>
        
        <label>Enter Age:</label>
        <input type="number" name="age" required>
        <br><br>

        <input type="submit" value="Check Eligibility">
    </form>

    <%
        // Get name and age from request
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        if (name != null && ageStr != null) {
            int age = Integer.parseInt(ageStr);

            // Check eligibility
            if (age >= 18) {
    %>
                <p class="eligible"><%= name %> is eligible for voting.</p>
    <%
            } else {
    %>
                <p class="not-eligible"><%= name %> is NOT eligible for voting.</p>
    <%
            }
        }
    %>

</body>
</html>
