<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Perfect Number Checker</title>
</head>
<body>
    <h2>Check if a Number is Perfect</h2>
    
    <form method="post">
        Enter a Number: <input type="number" name="number" required>
        <input type="submit" value="Check">
    </form>

    <%
        // Check if a number is submitted
        String numStr = request.getParameter("number");
        if (numStr != null) {
            int num = Integer.parseInt(numStr);
            int sum = 0;

            // Finding divisors and adding them
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }

            // Display result
            if (sum == num) {
                out.println("<h3 style='color:green;'>" + num + " is a Perfect Number</h3>");
            } else {
                out.println("<h3 style='color:red;'>" + num + " is NOT a Perfect Number</h3>");
            }
        }
    %>
</body>
</html>
