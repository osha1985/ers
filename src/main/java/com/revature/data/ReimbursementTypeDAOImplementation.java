package com.revature.data;

import com.revature.beans.ReimbursementType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yehur on 12/13/2016.
 */
public class ReimbursementTypeDAOImplementation implements ReimbursementTypeDAO {
    Connection connection = null;

    public ReimbursementTypeDAOImplementation(Connection connection) {
        this.connection = connection;
    }

    public ReimbursementType getReimbursementType(int typeID) {
        String sql = "SELECT REIMB_TYPE FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";
        PreparedStatement statement;
        ResultSet resultSet;
        String type = "";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, typeID);
            resultSet = statement.executeQuery();
            resultSet.next();
            type = resultSet.getString("REIMB_TYPE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ReimbursementType(typeID, type);

    }
}
