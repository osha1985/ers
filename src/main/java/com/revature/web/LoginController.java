package com.revature.web;

import com.revature.beans.User;
import com.revature.middle.BusinessDelegate;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController{
    protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username;
        String password;
        User user;
        BusinessDelegate delegate = new BusinessDelegate();
        PrintWriter writer = response.getWriter();
        try {
            username = request.getParameter("username");
            password = request.getParameter("password");
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("reimbursementTypes", delegate.getReimbursementTypes());
            request.getSession().setAttribute("reimbursementStatus", delegate.getReimbursementStatus());
            user = delegate.login(username, password);
            request.getSession().setAttribute("user", user);
            if (user.getRole().getUserRole().equals("Finance Manager")) {
                request.setAttribute("reimbursements", delegate.viewAllReimbursements());
                request.getRequestDispatcher("manager.jsp").forward(request, response);
            } else {
                request.setAttribute("reimbursements", delegate.getReimbursements(username));
                request.getRequestDispatcher("employee.jsp").forward(request, response);
            }
        } catch (AuthenticationException e) {
            writer.println(e.getMessage());
        }
    }
}
