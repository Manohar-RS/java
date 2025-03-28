<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>

    <form method="post">
        <label>Enter a Number:</label>
        <input type="number" name="num" required>
        <input type="submit" value="Calculate">
    </form>

    <%
        // Get input number from form
        String numStr = request.getParameter("num");

        if (numStr != null && !numStr.isEmpty()) {
            int num = Integer.parseInt(numStr);

            // Extract first and last digit
            int lastDigit = num % 10;
            int firstDigit = Integer.parseInt(Character.toString(numStr.charAt(0)));

            // Calculate sum
            int sum = firstDigit + lastDigit;
    %>

    <h3 style="color:red; font-size:18px;">
        Sum of First and Last Digit: <%= sum %>
    </h3>

    <% } %>

</body>
</html>
