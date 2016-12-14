package com.revature.data;

import com.revature.beans.ReimbursementStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yehur on 12/13/2016.
 */
public class ReimbursementStatusDAOImplementation implements ReimbursementStatusDAO {

    private Connection connection = null;

    public ReimbursementStatusDAOImplementation(Connection connection) {
        this.connection = connection;
    }

    public ReimbursementStatus getReimbursementStatus(int statusId) {
        String sql = "SELECT REIMB_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID = ?";
        PreparedStatement statement;
        String status = "";
        ResultSet resultSet;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,statusId);
            resultSet =  statement.executeQuery();
            resultSet.next();
            status = resultSet.getString("REIMB_STATUS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ReimbursementStatus(statusId, status);

    }
}
