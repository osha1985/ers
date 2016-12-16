package com.revature.middle;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;
import com.revature.beans.ReimbursementType;
import com.revature.beans.User;

import javax.naming.AuthenticationException;
import java.util.List;

public class BusinessDelegate {
    public User login(String user, String pass) throws AuthenticationException {
        return new UserService().authenticate(user, pass);
    }

    public void addReimbursementRequest(String username, double amount, String description, String receipt, ReimbursementStatus status, int typeId) throws AuthenticationException {
        new UserService().addReimbursementRequest(username, amount, description, receipt, status, typeId);
    }

    public void approveReimbursement(int reimbursementId, int statusId) {
        // TODO Auto-generated method stub
        new UserService().approveReimbursement(reimbursementId, statusId);
    }

    public List<ReimbursementStatus> getReimbursementStatus() {
        return new UserService().getReimbursementStatus();
    }

    public List<Reimbursement> viewAllReimbursements() throws AuthenticationException {
        // TODO Auto-generated method stub
        return new UserService().getAllReimbursements();
    }

    public List<ReimbursementType> getReimbursementTypes() {
        return new UserService().getReimbursementTypes();
    }

    public List<Reimbursement> getReimbursements(String username) throws AuthenticationException {
        return new UserService().getReimbursements(username);
    }

    public void changeStatus(int reimbursementId, int reimbursementStatusId) {
        new UserService().changeStatus(reimbursementId, reimbursementStatusId);
    }
}
