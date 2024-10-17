package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/RechargeServlet")
public class RechargeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String planId = request.getParameter("planId");
        String planName = request.getParameter("planName");
        HttpSession session = request.getSession();
        session.setAttribute("rechargeMessage", "Recharge successful for Plan: " + planName);
        response.sendRedirect("rechargeConfirmation.jsp");
    }
}
