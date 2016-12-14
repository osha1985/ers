package com.revature.data;

import com.revature.beans.Reimbursement;
import com.revature.beans.Role;
import com.revature.beans.User;

import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Facade {
    private Connection connection = null;

    public Facade() {
        if (connection == null) {
            try {
                connection = ServiceLocator.getErsDatabase().getConnection();
            } catch (SQLException e) {
                System.out.println("Something went wrong getting a connection to the database");
            } catch (NamingException e) {
                System.out.println("Something went wrong getting the name of the database");
            }
        }
    }

    public User getUserByName(String username) throws AuthenticationException {
        UserDAO dao = UserDAOFactory.getInstance(connection);
        return dao.getByUsername(username);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        connection.close();
    }

    Role getUserRole(String username) throws AuthenticationException {
        UserDAO dao = UserDAOFactory.getInstance(connection);
        User user = dao.getByUsername(username);
        return user.getRole();
    }

    public void insert(String username, double amount, String description, String receipt, int statusId, String status, int typeId, String type) throws AuthenticationException {
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        Reimbursement reimbursement = dao.createNewReimbursement(username, amount, description, receipt, statusId, status, typeId, type);
        dao.insert(reimbursement);
    }

    public List<Reimbursement> getReimbursements() {
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        return dao.getReimbursements();
    }

    public Reimbursement getReimbursement(String username) throws AuthenticationException {
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        return dao.getReimbursement(username);
    }

    public void modifyReimbursement(int reimbursementId, int statusId) {
        // TODO Auto-generated method stub
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance(connection);
        dao.modifyReimbursement(reimbursementId, statusId);
    }
}
