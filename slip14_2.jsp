<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <form method="post">
        <label>Enter a Number:</label>
        <input type="text" name="num" required>
        <input type="submit" value="Calculate">
    </form>

    <%
        String numStr = request.getParameter("num");

        if (numStr != null && !numStr.isEmpty()) {
            // Convert the number string to integer
            int number = Integer.parseInt(numStr);

            // Get the last digit
            int lastDigit = number % 10;

            // Get the first digit (first character of the string)
            int firstDigit = numStr.charAt(0) - '0';

            // Calculate the sum
            int sum = firstDigit + lastDigit;
    %>
        <h3 style="color: red; font-size: 18px;">
            Sum of First and Last Digit: <%= sum %>
        </h3>
    <%
        }
    %>
</body>
</html>
