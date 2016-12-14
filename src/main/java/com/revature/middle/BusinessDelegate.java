package com.revature.middle;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;
import com.revature.beans.User;

import javax.naming.AuthenticationException;
import java.util.List;

public class BusinessDelegate {
    public User login(String user, String pass) throws AuthenticationException {
        return new UserService().authenticate(user, pass);
    }

    public void addReimbursementRequest(String username, double amount, String description, String receipt, int statusId, String status, int typeId, String type) throws AuthenticationException {
        new UserService().addReimbursementRequest(username, amount, description, receipt, statusId, status, typeId, type);
    }

    public ReimbursementStatus viewStatus(String username) throws AuthenticationException {
        return new UserService().getStatus(username);

    }

    public void approveReimbursement(int reimbursementId, int statusId) {
        // TODO Auto-generated method stub
        new UserService().approveReimbursement(reimbursementId, statusId);
    }
    //    public void denyReimbursement() {


    //    }
    public List<Reimbursement> viewAllReimbursements() {
        // TODO Auto-generated method stub
        return new UserService().getAllReimbursements();
    }

}
