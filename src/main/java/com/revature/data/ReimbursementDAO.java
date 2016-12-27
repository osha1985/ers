package com.revature.data;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;

import javax.naming.AuthenticationException;
import java.util.List;

/**
 * The interface Reimbursement dao.
 */
public interface ReimbursementDAO {

    /**
     * Insert.
     *
     * @param reimbursement the reimbursement
     */
    void insert(Reimbursement reimbursement);

    /**
     * Gets reimbursements.
     *
     * @return the reimbursements
     * @throws AuthenticationException the authentication exception
     */
    List<Reimbursement> getReimbursements() throws AuthenticationException;


    /**
     * Accepts a user's username and returns all the reimbursements that user submitted
     *
     * @param username The username of the user that submitted the reimbursements
     * @return A list of java beans that describe the user's reimbursement
     * @throws AuthenticationException If the username isn't found within the database,
     *                                 an AuthenticationException is thrown
     */
    List<Reimbursement> getReimbursements(String username) throws AuthenticationException;


    /**
     * Returns a new Reimbursement java bean using the arguments provided.
     *
     * @param username    The user's username
     * @param amount      The amount of money that is being asked to be reimbursed.
     * @param description A description of what the user is being asked to be reimbursed for
     * @param receipt     A receipt of the reimbursement
     * @param status      The status of the reimbursement
     * @param typeId      The id of the type of the reimbursement.
     * @return The newly created reimbursement
     * @throws AuthenticationException If the username can't be found in the database,
     *                                 an authentication exception is thrown
     */
    Reimbursement createNewReimbursement(String username, double amount, String description, String receipt, ReimbursementStatus status, int typeId) throws AuthenticationException;

    /**
     * Change status.
     *
     * @param reimbursementId       the reimbursement id
     * @param reimbursementStatusId the reimbursement status id
     * @param username              the username
     * @throws AuthenticationException the authentication exception
     */
    void changeStatus(int reimbursementId, int reimbursementStatusId, String username) throws AuthenticationException;
}
