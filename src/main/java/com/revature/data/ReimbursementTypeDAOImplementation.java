package com.revature.data;

import com.revature.beans.ReimbursementType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ReimbursementType> getReimbursementTypes() {
        String sql = "SELECT REIMB_TYPE_ID, REIMB_TYPE FROM ERS_REIMBURSEMENT_TYPE";
        PreparedStatement statement;
        ResultSet resultSet;
        List<ReimbursementType> types = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                types.add(new ReimbursementType(resultSet.getInt("REIMB_TYPE_ID"), resultSet.getString("REIMB_TYPE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }
}
