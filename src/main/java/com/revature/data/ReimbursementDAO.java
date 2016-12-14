package com.revature.data;

import com.revature.beans.Reimbursement;

import javax.naming.AuthenticationException;
import java.util.List;

public interface ReimbursementDAO {

    void insert(Reimbursement reimbursement);

    List<Reimbursement> getReimbursements();

    Reimbursement getReimbursement(String username) throws AuthenticationException;

    void modifyReimbursement(int reimbursementId, int statusId);

    Reimbursement createNewReimbursement(String username, double amount, String description, String receipt, int statusId, String status, int typeId, String type) throws AuthenticationException;
}
