package com.revature.web;

import com.revature.beans.ReimbursementStatus;
import com.revature.middle.BusinessDelegate;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReimbursementAddedController{
    public void doAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        String username = (String) request.getSession().getAttribute("username");
        PrintWriter writer = response.getWriter();
        try {
            businessDelegate.addReimbursementRequest(username,
                    Double.parseDouble(request.getParameter("reimbursementAmount")),
                    request.getParameter("reimbursementDescription"),
                    request.getParameter("reimbursementReceipt"),
                    new ReimbursementStatus(),
                    Integer.parseInt(request.getParameter("reimbursementType")));
        } catch (AuthenticationException e) {
            writer.println(e.getMessage());
        }
        request.getRequestDispatcher("reimbursementAdded.jsp").forward(request, response);
    }
}
