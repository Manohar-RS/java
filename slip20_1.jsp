<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Number to Words</title>
</head>
<body>
    <h2>नंबर डालें:</h2>
    <form method="post">
        <input type="text" name="number" required>
        <input type="submit" value="Convert">
    </form>

    <%
        // यूजर से नंबर लेना
        String num = request.getParameter("number");
        
        if (num != null && num.matches("\\d+")) { // चेक करें कि नंबर सही है
            String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
            String result = "";

            // हर अंक को शब्द में बदलें
            for (char digit : num.toCharArray()) {
                result += words[digit - '0'] + " ";
            }
    %>

    <h3 style="color:red; font-size:18px;"><%= result.trim() %></h3>

    <%
        } else if (num != null) {
    %>
        <h3 style="color:red;">❌ कृपया केवल नंबर डालें!</h3>
    <%
        }
    %>
</body>
</html>
