import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/slip18_2")
public class slip18_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Fetch input values from the form
        String seatNo = request.getParameter("seatNo");
        String name = request.getParameter("name");
        String className = request.getParameter("className");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));

        // Calculate percentage
        double percentage = (totalMarks / 500.0) * 100;
        
        // Determine grade based on percentage
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else {
            grade = "Fail";
        }

        // Set response type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Display the results
        out.println("<html><body>");
        out.println("<h2>Student Details</h2>");
        out.println("<table border='1' cellpadding='8'>");
        out.println("<tr><th>Seat No</th><th>Name</th><th>Class</th><th>Total Marks</th><th>Percentage</th><th>Grade</th></tr>");
        out.println("<tr><td>" + seatNo + "</td><td>" + name + "</td><td>" + className + "</td><td>" + totalMarks + "</td><td>" + String.format("%.2f", percentage) + "%</td><td>" + grade + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
    }
}
