package com.revature.data;
import java.sql.Connection;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {

    public void insert(Reimbursement reimb);

    public void setConnection(Connection connection);

    public List<Reimbursement> getReimbursements();

    public Reimbursement getReimbursement(String username);

    public void modifyReimbursement(int reimbursementId, int statusId);

}
