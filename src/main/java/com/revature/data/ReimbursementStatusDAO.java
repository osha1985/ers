package com.revature.data;

import com.revature.beans.ReimbursementStatus;

import java.util.List;

/**
 * The interface Reimbursement status dao.
 */
public interface ReimbursementStatusDAO {
    /**
     * Accepts the id of the reimbursement status and returns a java bean containing information about that status
     *
     * @param statusId The id of the status
     * @return A java bean containing information about the reimbursement status
     */
    ReimbursementStatus getReimbursementStatus(int statusId);

    /**
     * Gets reimbursement status.
     *
     * @return the reimbursement status
     */
    List<ReimbursementStatus> getReimbursementStatus();
}
