<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reverse String</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }
        h2 { color: blue; }
        .result { font-size: 20px; color: red; font-weight: bold; }
    </style>
</head>
<body>

    <h2>Enter a String to Reverse</h2>
    <form method="post">
        <input type="text" name="userString" required>
        <input type="submit" value="Reverse">
    </form>

    <%
        // Get input from user
        String userString = request.getParameter("userString");
        
        if (userString != null && !userString.isEmpty()) {
            // Reverse the string
            String reversedString = new StringBuilder(userString).reverse().toString();
    %>
            <p class="result">Reversed String: <%= reversedString %></p>
    <%
        }
    %>

</body>
</html>
