package servlets;

import dao.DB_Operations;
import model.Operator;
//import model.RechargePlan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/operators")
public class OperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB_Operations dbOperations = new DB_Operations();
        List<Operator> operators = dbOperations.getAllOperators();
        request.setAttribute("operators", operators);
        request.getRequestDispatcher("operators.jsp").forward(request, response);
    }
}
