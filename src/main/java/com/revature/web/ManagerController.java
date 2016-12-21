package com.revature.web;

import com.revature.middle.BusinessDelegate;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ManagerController{
    public void doAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        String username = (String) request.getSession().getAttribute("username");
        PrintWriter writer = response.getWriter();
        try {
            int reimbursementId = Integer.parseInt(request.getParameter("reimbursementId"));
            int reimbursementStatusId = Integer.parseInt(request.getParameter("reimbursementStatusId"));
            businessDelegate.changeStatus(reimbursementId, reimbursementStatusId, username);
            request.setAttribute("reimbursements", businessDelegate.viewAllReimbursements());
        } catch (AuthenticationException e) {
            writer.println(e.getMessage());
        }
        request.getRequestDispatcher("manager.jsp").forward(request, response);
    }
}
