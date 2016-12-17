package com.revature.data;

import com.revature.beans.*;

import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Facade {
    private Connection connection = null;

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

    Role getUserRole(String username) throws AuthenticationException {
        UserDAO dao = UserDAOFactory.getInstance(connection);
        User user = dao.getByUsername(username);
        closeConnection();
        return user.getRole();
    }

    public void insert(String username, double amount, String description, String receipt, ReimbursementStatus status, int typeId) throws AuthenticationException {
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        Reimbursement reimbursement = dao.createNewReimbursement(username, amount, description, receipt, status, typeId);
        dao.insert(reimbursement);
        closeConnection();
    }

    public List<Reimbursement> getReimbursements() throws AuthenticationException {
        List<Reimbursement> list;
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        list = dao.getReimbursements();
        closeConnection();
        return list;
    }

    public List<Reimbursement> getReimbursements(String username) throws AuthenticationException {
        List<Reimbursement> list;
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        list = dao.getReimbursements(username);
        closeConnection();
        return list;
    }

    public List<ReimbursementStatus> getReimbursementStatus() {
        List<ReimbursementStatus> statusList;
        ReimbursementStatusDAO dao = ReimbursementStatusDAOFactory.getInstance(connection);
        statusList = dao.getReimbursementStatus();
        closeConnection();
        return statusList;
    }

    public List<ReimbursementType> getReimbursementTypes() {
        ReimbursementTypeDAO dao = ReimbursementTypeDAOFactory.getInstance(connection);
        List<ReimbursementType> types;
        types = dao.getReimbursementTypes();
        closeConnection();
        return types;
    }

    public void changeStatus(int reimbursementId, int reimbursementStatusId) {
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        dao.changeStatus(reimbursementId, reimbursementStatusId);
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
