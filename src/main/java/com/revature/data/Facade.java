package com.revature.data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.AuthenticationException;
import javax.naming.NamingException;

import com.revature.beans.Reimbursement;
import com.revature.beans.Role;
import com.revature.beans.User;

public class Facade {
    private Connection connection = null;

    public Facade() {
        if (connection == null) {
            try {
                connection = ServiceLocator.getErsDatabase().getConnection();
            } catch (SQLException e) {
                System.out.println("Something went wrong getting a connection to the database");
            } catch(NamingException e) {
                System.out.println("Something went wrong getting the name of the database");
            }
        }
    }

    public User getUserByName(String username) throws AuthenticationException {
        UserDAO dao = UserDAOFactory.getInstance();
        dao.setConnection(connection);
        return dao.getByUsername(username);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        connection.close();
    }

    Role getUserRole(String username) throws AuthenticationException{
        UserDAO dao = UserDAOFactory.getInstance();
        dao.setConnection(connection);
        return dao.getUserRole(username);
    }

    public void insert(String username, double amount, String description, String receipt, int typeId, String type) {
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance();
        dao.setConnection(connection);
        Reimbursement reimbursement = new Reimbursement(username, amount, description, receipt, typeId, type, connection);
        dao.insert(reimbursement);
    }
    public List<Reimbursement> getReimbursements() {
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance();
        dao.setConnection(connection);
        return dao.getReimbursements();
    }
    public Reimbursement getReimbursement(String username) {
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance();
        dao.setConnection(connection);
        return dao.getReimbursement(username);
    }

    public void modifyReimbursement(int reimbursementId, int statusId) {
        // TODO Auto-generated method stub
        ReimbursementDAO dao = ReimbursementDAOFactory.getInstance();
        dao.setConnection(connection);
        dao.modifyReimbursement(reimbursementId, statusId);
    }
}
