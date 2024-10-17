package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DB_Operations;
@WebServlet("/deletePlan")
public class DeletePlanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        DB_Operations dbOperations = new DB_Operations();
        dbOperations.deleteRechargePlan(id);
        
        response.sendRedirect("adminDashboard.jsp");
    }
}
