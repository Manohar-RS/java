<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Prime Number Checker</title>
    <style>
        .result { color: red; font-weight: bold; }
    </style>
</head>
<body>
    <h2>Check Prime Number</h2>
    <form method="post">
        Enter a number: <input type="number" name="num" required>
        <input type="submit" value="Check">
    </form>

    <%
        // Get the number from the form
        String numStr = request.getParameter("num");

        if (numStr != null) {
            int num = Integer.parseInt(numStr);
            boolean isPrime = true;

            // Prime number logic: A prime number is only divisible by 1 and itself.
            if (num <= 1) {
                isPrime = false; // 1 and below are not prime numbers
            } else {
                for (int i = 2; i < num; i++) { // Check divisibility from 2 to (num - 1)
                    if (num % i == 0) {
                        isPrime = false; // If divisible, not prime
                        break;
                    }
                }
            }

            // Display result in red
            out.println("<p class='result'>The number " + num + " is " + (isPrime ? "a Prime Number" : "NOT a Prime Number") + ".</p>");
        }
    %>
</body>
</html>

