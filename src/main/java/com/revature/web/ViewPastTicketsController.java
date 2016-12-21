package com.revature.web;

import com.revature.middle.BusinessDelegate;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ViewPastTicketsController{
    public void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        String username = (String) request.getSession().getAttribute("username");
        PrintWriter writer = response.getWriter();
        try {
            request.setAttribute("reimbursements", businessDelegate.getReimbursements(username));
        } catch (AuthenticationException e) {
            writer.println(e.getMessage());
        }
        request.getRequestDispatcher("viewPastTickets.jsp").forward(request, response);
    }
}
