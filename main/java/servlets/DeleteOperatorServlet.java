package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DB_Operations;

/**
 * Servlet implementation class DeleteOperatorServlet
 */
@WebServlet("/deleteOperator")
public class DeleteOperatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        DB_Operations dbOperations = new DB_Operations();
        if (!dbOperations.deleteOperator(id)) {
            request.setAttribute("errorMessage", "Failed to delete operator.");
            request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
            return;
        }

        response.sendRedirect("adminDashboard.jsp");
    }
}