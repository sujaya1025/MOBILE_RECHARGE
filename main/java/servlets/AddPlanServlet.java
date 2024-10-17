package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DB_Operations;

@WebServlet("/addPlan")
public class AddPlanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String planName = request.getParameter("planName");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int operatorId = Integer.parseInt(request.getParameter("operatorId"));
        int id = Integer.parseInt(request.getParameter("id"));

        DB_Operations dbOperations = new DB_Operations();
        boolean isAdded = dbOperations.addRechargePlan(id, operatorId, planName, description, price); 
        
        if (isAdded) {
            response.sendRedirect("adminDashboard.jsp"); 
        } else {
            request.setAttribute("errorMessage", "Failed to add recharge plan. Please try again."); 
            request.getRequestDispatcher("addPlan.jsp").forward(request, response); 
        }
    }
}
