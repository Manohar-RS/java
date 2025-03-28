import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchCustomerServlet")
public class slip11_1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get customer number from request
        String custNumber = request.getParameter("custNumber");
        
        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "root", "password");

            // Prepare SQL statement
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE cust_id = ?");
            ps.setString(1, custNumber);
            ResultSet rs = ps.executeQuery();

            out.println("<h2>Customer Details</h2>");
            if (rs.next()) {
                out.println("<p>Customer ID: " + rs.getInt("cust_id") + "</p>");
                out.println("<p>Name: " + rs.getString("name") + "</p>");
                out.println("<p>Email: " + rs.getString("email") + "</p>");
                out.println("<p>Phone: " + rs.getString("phone") + "</p>");
            } else {
                out.println("<p style='color:red;'>Customer Not Found!</p>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }
    }
}
