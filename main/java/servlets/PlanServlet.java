package servlets;

import dao.DB_Operations;
import model.RechargePlan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/plans")
public class PlanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operatorIdParam = request.getParameter("operatorId");
        int operatorId = Integer.parseInt(operatorIdParam); 

        DB_Operations dbOperations = new DB_Operations();
        List<RechargePlan> plans = dbOperations.getPlansByOperatorId(operatorId);
        request.setAttribute("plans", plans);
        request.setAttribute("operatorId", operatorId);
        request.getRequestDispatcher("plans.jsp").forward(request, response);
    }
}
