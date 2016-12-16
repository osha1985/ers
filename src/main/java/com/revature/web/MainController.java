package com.revature.web;

import com.revature.beans.ReimbursementStatus;
import com.revature.beans.User;
import com.revature.middle.BusinessDelegate;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private User user = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        BusinessDelegate businessDelegate = new BusinessDelegate();
        request.setAttribute("reimbursementTypes", businessDelegate.getReimbursementTypes());
        request.setAttribute("reimbursementStatus", businessDelegate.getReimbursementStatus());
        try {
            request.setAttribute("reimbursements", businessDelegate.viewAllReimbursements());
        } catch (AuthenticationException e) {
            PrintWriter writer = response.getWriter();
            writer.println(e.getMessage());
        }
        switch (uri) {
            case "/Project/login": {
                username = request.getParameter("username");
                password = request.getParameter("password");
                try {
                    user = businessDelegate.login(username, password);
                    if (user.getRole().getUserRole().equals("Finance Manager")) {
                        request.setAttribute("reimbursements", businessDelegate.viewAllReimbursements());
                        request.getRequestDispatcher("manager.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("employee.jsp").forward(request, response);
                    }
                } catch (AuthenticationException e) {
                    PrintWriter writer = response.getWriter();
                    writer.println(e.getMessage());
                }
                break;
            }
            case "/Project/employee": {
                request.getRequestDispatcher("employee.jsp").forward(request, response);
                break;
            }
            case "/Project/addReimbursement": {
                request.getRequestDispatcher("addReimbursement.jsp").forward(request, response);
                break;
            }
            case "/Project/viewPastTickets": {
                try {
                    request.setAttribute("reimbursements", businessDelegate.getReimbursements(username));
                } catch (AuthenticationException e) {
                    PrintWriter writer = response.getWriter();
                    writer.println(e.getMessage());
                }
                request.getRequestDispatcher("viewPastTickets.jsp").forward(request, response);
                break;
            }
            case "/Project/reimbursementAdded": {
                try {
                    businessDelegate.addReimbursementRequest(username,
                            Double.parseDouble(request.getParameter("reimbursementAmount")),
                            request.getParameter("reimbursementDescription"),
                            "C:/Users/yehur/Desktop/a.gif",
                            new ReimbursementStatus(),
                            Integer.parseInt(request.getParameter("reimbursementType")));
                } catch (AuthenticationException e) {
                    PrintWriter writer = response.getWriter();
                    writer.println(e.getMessage());
                }
                request.getRequestDispatcher("reimbursementAdded.jsp").forward(request, response);
            }
            case "/Project/manager": {
                businessDelegate.changeStatus(Integer.parseInt(request.getParameter("reimbursementId")), Integer.parseInt(request.getParameter("reimbursementStatusId")));
                request.getRequestDispatcher("manager.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(req, resp);
    }
}
