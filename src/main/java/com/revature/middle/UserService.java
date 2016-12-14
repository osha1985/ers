package com.revature.middle;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;
import com.revature.beans.User;
import com.revature.data.Facade;
import org.mindrot.jbcrypt.BCrypt;

import javax.naming.AuthenticationException;
import java.util.List;
public class UserService {
    User authenticate(String username, String password) throws AuthenticationException {
        Facade dataTier = new Facade();
        User user = dataTier.getUserByName(username);
        if (user == null) {
            throw new AuthenticationException("User name not found");
        }
        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new AuthenticationException("The password is incorrect");
        }
        return user;
    }

    public ReimbursementStatus getStatus(String username) throws AuthenticationException {
        // TODO Auto-generated method stub
        Facade dataTier = new Facade();
        return dataTier.getReimbursement(username).getStatus();
    }


    public List<Reimbursement> getAllReimbursements() {
        // TODO Auto-generated method stub
        Facade dataTier = new Facade();
        return dataTier.getReimbursements();
    }

    public void addReimbursementRequest(String username, double amount, String description, String receipt, int statusId, String status, int typeId, String type) throws AuthenticationException {
        // TODO Auto-generated method stub
        Facade dataTier = new Facade();
        dataTier.insert(username, amount, description, receipt, statusId, status, typeId, type);
    }

    public void approveReimbursement(int reimbursementId, int statusId) {
        // TODO Auto-generated method stub
        Facade dataTier = new Facade();
        dataTier.modifyReimbursement(reimbursementId, statusId);

    }
}