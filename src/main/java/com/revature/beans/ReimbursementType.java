package com.revature.beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementType {
    private int typeId;
    private String type;

    public ReimbursementType(int typeId, String type) {
        super();
        this.typeId = typeId;
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public ReimbursementType() {
        super();
    }


    public ReimbursementType(int typeId, Connection connection) {
        // TODO Auto-generated constructor stub
        PreparedStatement statement;
        ResultSet resultSet;
        String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, typeId);
            resultSet = statement.executeQuery();
            resultSet.next();
            type = resultSet.getString("REIMB_TYPE");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Something went wrong getting the reimbursement type");
        }
    }

    @Override
    public String toString() {
        return "ReimbursementType [typeId=" + typeId + ", type=" + type + "]";
    }
}
