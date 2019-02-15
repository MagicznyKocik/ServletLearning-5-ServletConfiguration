package pl.adamLupinski.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// parameters and mappping passed by xml
@WebServlet
public class WelcomeServlet2 extends HttpServlet {
    private static final long serialVersionUID =1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        if (username==null || "".equals(username)){
            username = getServletConfig().getInitParameter("defaultUsername");
        }
        sendResponse(response, username);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void sendResponse(HttpServletResponse response, String username) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head><title>Hello " + username + "</title></head>");
        writer.println("<body>");
        writer.println("<h1>Hello " + username + "</h1>");
        writer.println("</body>");
        writer.println("</html>");

    }
}
