package com.revature.data;

import com.revature.beans.ReimbursementType;

import java.util.List;

/**
 * The interface Reimbursement type dao.
 */
public interface ReimbursementTypeDAO {
    /**
     * Accepts a type id of a reimbursement type and returns a java bean containing information about that type
     *
     * @param typeID the type id
     * @return A java bean containing information about the reimbursement type
     */
    ReimbursementType getReimbursementType(int typeID);

    /**
     * Returns a list of all the different types of reimbursements in the database
     *
     * @return A list of java beans which contain information about the reimbursement type
     */
    List<ReimbursementType> getReimbursementTypes();
}
