package com.revature.data;

import com.revature.beans.*;

import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * The type Facade.
 */
public class Facade {
    private Connection connection = null;

    /**
     * Instantiates a new Facade.
     */
    public Facade() {
        try {
            if(connection == null) {
                connection = ServiceLocator.getErsDatabase().getConnection();
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong getting a connection to the database");
        } catch (NamingException e) {
            System.out.println("Something went wrong getting the name of the database");
        }
    }

    /**
     * Gets user by name.
     *
     * @param username the username
     * @return the user by name
     * @throws AuthenticationException the authentication exception
     */
    public User getUserByName(String username) throws AuthenticationException {
        UserDAO dao = UserDAOFactory.getInstance(connection);
        User user = dao.getByUsername(username);
        closeConnection();
        return user;
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }

    /**
     * Gets user role.
     *
     * @param username the username
     * @return the user role
     * @throws AuthenticationException the authentication exception
     */
    Role getUserRole(String username) throws AuthenticationException {
        UserDAO dao = UserDAOFactory.getInstance(connection);
        User user = dao.getByUsername(username);
        closeConnection();
        return user.getRole();
    }

    /**
     * Insert.
     *
     * @param username    the username
     * @param amount      the amount
     * @param description the description
     * @param receipt     the receipt
     * @param status      the status
     * @param typeId      the type id
     * @throws AuthenticationException the authentication exception
     */
    public void insert(String username, double amount, String description, String receipt, ReimbursementStatus status, int typeId) throws AuthenticationException {
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        Reimbursement reimbursement = dao.createNewReimbursement(username, amount, description, receipt, status, typeId);
        dao.insert(reimbursement);
        closeConnection();
    }

    /**
     * Gets reimbursements.
     *
     * @return the reimbursements
     * @throws AuthenticationException the authentication exception
     */
    public List<Reimbursement> getReimbursements() throws AuthenticationException {
        List<Reimbursement> list;
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        list = dao.getReimbursements();
        closeConnection();
        return list;
    }

    /**
     * Gets reimbursements.
     *
     * @param username the username
     * @return the reimbursements
     * @throws AuthenticationException the authentication exception
     */
    public List<Reimbursement> getReimbursements(String username) throws AuthenticationException {
        List<Reimbursement> list;
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        list = dao.getReimbursements(username);
        closeConnection();
        return list;
    }

    /**
     * Gets reimbursement status.
     *
     * @return the reimbursement status
     */
    public List<ReimbursementStatus> getReimbursementStatus() {
        List<ReimbursementStatus> statusList;
        ReimbursementStatusDAO dao = ReimbursementStatusDAOFactory.getInstance(connection);
        statusList = dao.getReimbursementStatus();
        closeConnection();
        return statusList;
    }

    /**
     * Gets reimbursement types.
     *
     * @return the reimbursement types
     */
    public List<ReimbursementType> getReimbursementTypes() {
        ReimbursementTypeDAO dao = ReimbursementTypeDAOFactory.getInstance(connection);
        List<ReimbursementType> types;
        types = dao.getReimbursementTypes();
        closeConnection();
        return types;
    }

    /**
     * Change status.
     *
     * @param reimbursementId       the reimbursement id
     * @param reimbursementStatusId the reimbursement status id
     * @param username              the username
     * @throws AuthenticationException the authentication exception
     */
    public void changeStatus(int reimbursementId, int reimbursementStatusId, String username) throws AuthenticationException {
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        dao.changeStatus(reimbursementId, reimbursementStatusId, username);
        closeConnection();
    }
    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = null;
    }
}
