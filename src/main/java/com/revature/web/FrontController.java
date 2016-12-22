package com.revature.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FrontController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getRequestURI()) {
            case "/Project/login": {
                new LoginController().doAll(request, response);
                break;
            }
            case "/Project/employee": {
                new EmployeeController().doAll(request, response);
                break;
            }
            case "/Project/addReimbursement": {
                new AddReimbursementController().doAll(request, response);
                break;
            }
            case "/Project/viewPastTickets": {
                new ViewPastTicketsController().doAll(request, response);
                break;
            }
            case "/Project/reimbursementAdded": {
                new ReimbursementAddedController().doAll(request, response);
                break;
            }
            case "/Project/manager": {
                new ManagerController().doAll(request, response);
                break;
            }
            case "/Project/logout": {
                new LogoutController().doAll(request, response);
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
