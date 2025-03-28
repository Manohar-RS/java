<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 100px;
        }
        h1 {
            color: blue;
        }
    </style>
</head>
<body>

    <form method="post">
        <label>Enter Your Name: </label>
        <input type="text" name="userName" required>
        <input type="submit" value="Greet Me">
    </form>

    <%
        // Get the username from the form
        String userName = request.getParameter("userName");
   // && !userName.trim().isEmpty()
        if (userName != null ) {
            // Get current hour
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            // Determine greeting message
            String greeting;
            if (hour >= 5 && hour < 12) {
                greeting = "Good Morning";
            } else if (hour >= 12 && hour < 17) {
                greeting = "Good Afternoon";
            } else {
                greeting = "Good Evening";
            }
    %>

    <h1><%= greeting %>, <%= userName %>!</h1>

    <%
        }
    %>

</body>
</html>
