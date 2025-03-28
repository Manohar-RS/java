import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/slip15_2")
public class slip15_2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int visitCount = 0;
        boolean isNewVisitor = true;

        // Get cookies from the request
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue()); // Get previous count
                    isNewVisitor = false;
                    break;
                }
            }
        }

        visitCount++; // Increment visit count

        // Store updated count in cookie
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24 * 30); // Cookie valid for 30 days
        response.addCookie(visitCookie);

        // Display message
        out.println("<html><head><title>Visit Counter</title></head><body>");
        if (isNewVisitor) {
            out.println("<h2>Welcome to our website! This is your first visit.</h2>");
        } else {
            out.println("<h2>Welcome back! You have visited this page " + visitCount + " times.</h2>");
        }
        out.println("</body></html>");
    }
}
