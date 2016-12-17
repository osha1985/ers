package com.revature.data;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;

import javax.naming.AuthenticationException;
import java.util.List;

public interface ReimbursementDAO {

    void insert(Reimbursement reimbursement);

    List<Reimbursement> getReimbursements() throws AuthenticationException;


    List<Reimbursement> getReimbursements(String username) throws AuthenticationException;


    Reimbursement createNewReimbursement(String username, double amount, String description, String receipt, ReimbursementStatus status, int typeId) throws AuthenticationException;

    void changeStatus(int reimbursementId, int reimbursementStatusId);
}
