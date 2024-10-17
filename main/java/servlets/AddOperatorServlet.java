package servlets;

import dao.DB_Operations;
import model.Operator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addOperator")
public class AddOperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String description = req.getParameter("description");

       
        int id = 0;
        try {
            id = Integer.parseInt(idStr); 
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Invalid ID format.");
            req.getRequestDispatcher("addOperator.jsp").forward(req, resp);
            return;
        }

        
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            req.setAttribute("errorMessage", "Name and Description are required.");
            req.getRequestDispatcher("addOperator.jsp").forward(req, resp);
            return;
        }

        
        Operator operator = new Operator(id, name, description);

        
        DB_Operations db = new DB_Operations();
        boolean isSuccess = db.addOperator(operator);

        if (isSuccess) {
            req.setAttribute("successMessage", "Operator added successfully.");
            req.getRequestDispatcher("addOperator.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "Failed to add operator. Try again.");
            req.getRequestDispatcher("addOperator.jsp").forward(req, resp);
        }
    }
}
