package com.revature.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;
import com.revature.beans.ReimbursementType;
import com.revature.beans.User;


public class ReimbursementDAOImplementation implements ReimbursementDAO {
    private Connection connection = null;

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
            statement.setBlob(4, reimbursement.getReceipt());
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

    public void setConnection(Connection connection) {
        // TODO Auto-generated method stub
        if (this.connection == null) {
            this.connection = connection;
        }
    }

    @Override
    public List<Reimbursement> getReimbursements() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM ERS_REIMBURSEMENT";
        ResultSet resultSet;
        ArrayList<Reimbursement> list = new ArrayList<>();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                list.add(new Reimbursement(resultSet.getInt("REIMB_ID"), resultSet.getDouble("REIMB_AMOUNT"), resultSet.getTimestamp("REIMB_SUBMITTED"), resultSet.getTimestamp("REIMB_RESOLVED"), resultSet.getString("REIMB_DESCRIPTION"), resultSet.getBinaryStream("REIMB_RECEIPT"), new User(resultSet.getInt("REIMB_AUTHOR"), connection),null, new ReimbursementStatus(resultSet.getInt("REIMB_STATUS_ID"), connection), new ReimbursementType(resultSet.getInt("REIMB_TYPE_ID"), connection)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Something went wrong when getting the list of reimbursements");
        }
        return list;
    }

    @Override
    public Reimbursement getReimbursement(String username) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM"
                + " (ERS_REIMBURSEMENT JOIN ERS_USERS ON ERS_USERS_ID = REIMB_AUTHOR) "
                + "WHERE ERS_USERNAME = ?";
        PreparedStatement statement;
        ResultSet resultSet;
        Reimbursement reimbursement = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            resultSet.next();
            reimbursement = new Reimbursement(resultSet.getInt("REIMB_ID"), resultSet.getDouble("REIMB_AMOUNT"), resultSet.getTimestamp("REIMB_SUBMITTED"), resultSet.getTimestamp("REIMB_RESOLVED"), resultSet.getString("REIMB_DESCRIPTION"), resultSet.getBinaryStream("REIMB_RECEIPT"), new User(resultSet.getInt("REIMB_AUTHOR"), connection), null, new ReimbursementStatus(resultSet.getInt("REIMB_STATUS_ID"), connection), new ReimbursementType(resultSet.getInt("REIMB_TYPE_ID"), connection));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("SQL Exception: The reimbursement couldn't be retrieved");
        }
        return reimbursement;
    }

    @Override
    public void modifyReimbursement(int reimbursementId, int statusId) {
        // TODO Auto-generated method stub
        String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = ? WHERE REIMB_ID = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, statusId);
            preparedStatement.setInt(2, reimbursementId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Something went wrong updating the status of the reimbursement");
        }


    }

}
