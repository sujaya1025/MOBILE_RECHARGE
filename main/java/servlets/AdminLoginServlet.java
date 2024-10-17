package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.DB_Operations;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DB_Operations dbOperations = new DB_Operations();

        
        boolean isValidAdmin = dbOperations.validateAdmin(username, password);

        if(isValidAdmin) {
          
            HttpSession session = request.getSession(true); 
            session.setAttribute("admin", username);
            
            response.sendRedirect("adminDashboard.jsp");
        } else {
           
            response.sendRedirect("adminLogin.jsp?error=invalid");
        }
    }
}
