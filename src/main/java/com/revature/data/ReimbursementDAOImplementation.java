package com.revature.data;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;
import com.revature.beans.ReimbursementType;
import com.revature.beans.User;

import javax.naming.AuthenticationException;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;


/**
 * The type Reimbursement dao implementation.
 */
public class ReimbursementDAOImplementation implements ReimbursementDAO {
    private Connection connection = null;


    /**
     * Instantiates a new Reimbursement dao implementation.
     *
     * @param connection the connection
     */
    public ReimbursementDAOImplementation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Reimbursement reimbursement) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO ERS_REIMBURSEMENT"
                + " (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, reimbursement.getAmount());
            statement.setTimestamp(2, reimbursement.getSubmitted());
            statement.setString(3, reimbursement.getDescription());
            statement.setBlob(4, base64StringToBlob(reimbursement.getReceipt()).getBinaryStream());
            statement.setInt(5, reimbursement.getAuthor().getUserId());
            statement.setInt(6, reimbursement.getStatus().getStatusId());
            statement.setInt(7, reimbursement.getType().getTypeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //System.out.println(" SQL Exception: The reimbursement couldn't be inserted");
            e.printStackTrace();
        }
    }

    @Override
    public List<Reimbursement> getReimbursements() throws AuthenticationException {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM ERS_REIMBURSEMENT";
        ResultSet resultSet;
        ArrayList<Reimbursement> list = new ArrayList<>();
        PreparedStatement statement;
        UserDAO userDAO = UserDAOFactory.getInstance(connection);
        ReimbursementTypeDAO typeDAO = ReimbursementTypeDAOFactory.getInstance(connection);
        ReimbursementStatusDAO statusDAO = ReimbursementStatusDAOFactory.getInstance(connection);
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new Reimbursement(resultSet.getInt("REIMB_ID"),
                        resultSet.getDouble("REIMB_AMOUNT"),
                        resultSet.getTimestamp("REIMB_SUBMITTED"),
                        resultSet.getTimestamp("REIMB_RESOLVED"),
                        resultSet.getString("REIMB_DESCRIPTION"),
                        blobToBase64String(resultSet.getBlob("REIMB_RECEIPT")),
                        userDAO.getByUserId(resultSet.getInt("REIMB_AUTHOR")),
                        resultSet.getInt("REIMB_RESOLVER") != 0 ? userDAO.getByUserId(resultSet.getInt("REIMB_RESOLVER")) : null,
                        statusDAO.getReimbursementStatus(resultSet.getInt("REIMB_STATUS_ID")),
                        typeDAO.getReimbursementType(resultSet.getInt("REIMB_TYPE_ID"))));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Something went wrong when getting the list of reimbursements");
        }
        return list;
    }

    @Override
    public List<Reimbursement> getReimbursements(String username) throws AuthenticationException {
        // TODO Auto-generated method stub
        UserDAO userDAO = UserDAOFactory.getInstance(connection);
        ReimbursementTypeDAO typeDAO = ReimbursementTypeDAOFactory.getInstance(connection);
        ReimbursementStatusDAO statusDAO = ReimbursementStatusDAOFactory.getInstance(connection);
        String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
        User user = userDAO.getByUsername(username);
        PreparedStatement statement;
        ResultSet resultSet;
        List<Reimbursement> reimbursements = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getUserId());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reimbursements.add(new Reimbursement(resultSet.getInt("REIMB_ID"),
                        resultSet.getDouble("REIMB_AMOUNT"),
                        resultSet.getTimestamp("REIMB_SUBMITTED"),
                        resultSet.getTimestamp("REIMB_RESOLVED"),
                        resultSet.getString("REIMB_DESCRIPTION"),
                        blobToBase64String(resultSet.getBlob("REIMB_RECEIPT")),
                        userDAO.getByUserId(resultSet.getInt("REIMB_AUTHOR")),
                        resultSet.getInt("REIMB_RESOLVER") != 0 ? userDAO.getByUserId(resultSet.getInt("REIMB_RESOLVER")) : null,
                        statusDAO.getReimbursementStatus(resultSet.getInt("REIMB_STATUS_ID")),
                        typeDAO.getReimbursementType(resultSet.getInt("REIMB_TYPE_ID"))));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("SQL Exception: The reimbursements couldn't be retrieved");
        }
        return reimbursements;
    }

    @Override
    public Reimbursement createNewReimbursement(String username, double amount, String description, String receipt, ReimbursementStatus status, int typeId) throws AuthenticationException {
        UserDAO userDAO = UserDAOFactory.getInstance(connection);
        ReimbursementTypeDAO typeDAO = ReimbursementTypeDAOFactory.getInstance(connection);
        User user = userDAO.getByUsername(username);
        ReimbursementType type = typeDAO.getReimbursementType(typeId);
        return new Reimbursement(user.getUserId(), amount, new Timestamp(new Date().getTime()), null, description, receipt, user, null, status, type);
    }

    @Override
    public void changeStatus(int reimbursementId, int reimbursementStatusId, String username) throws AuthenticationException {
        String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = ?, REIMB_RESOLVER = ?, REIMB_RESOLVED = ? WHERE REIMB_ID = ?";
        UserDAO userDAO = UserDAOFactory.getInstance(connection);
        User user = userDAO.getByUsername(username);
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, reimbursementStatusId);
            statement.setInt(2, user.getUserId());
            statement.setTimestamp(3, new Timestamp(new Date().getTime()));
            statement.setInt(4, reimbursementId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String blobToBase64String(Blob blob) {
        String string = "";
        try {
            string = Base64.getEncoder().encodeToString(blob.getBytes(1, (int) blob.length()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return string;
    }

    private Blob base64StringToBlob(String base64) {
        Blob blob = null;
        try {
            blob = new SerialBlob(Base64.getDecoder().decode(base64));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blob;
    }

}
