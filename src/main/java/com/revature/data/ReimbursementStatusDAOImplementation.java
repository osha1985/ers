package com.revature.data;

import com.revature.beans.ReimbursementStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ReimbursementStatus> getReimbursementStatus() {
        String sql = "SELECT REIMB_STATUS_ID, REIMB_STATUS FROM ERS_REIMBURSEMENT_STATUS";
        List<ReimbursementStatus> values = new ArrayList<>();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                values.add(new ReimbursementStatus(resultSet.getInt("REIMB_STATUS_ID"), resultSet.getString("REIMB_STATUS")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }
}
