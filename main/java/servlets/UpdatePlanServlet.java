package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DB_Operations;

@WebServlet("/updatePlan")
public class UpdatePlanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String planName = request.getParameter("planName");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        DB_Operations dbOperations = new DB_Operations();
        boolean isUpdated = dbOperations.updateRechargePlan(id, planName, price, description); 
        
        if (isUpdated) {
            response.sendRedirect("adminDashboard.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to update plan.");
        }
    }
}
