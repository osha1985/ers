package com.revature.beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementStatus {
    @Override
    public String toString() {
        return "ReimbursementStatus [statusId=" + statusId + ", status=" + status + "]";
    }

    private int statusId;
    private String status;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReimbursementStatus(int statusId, String status) {
        super();
        this.statusId = statusId;
        this.status = status;
    }

    public ReimbursementStatus() {
        super();
    }

    public ReimbursementStatus(int statusId, Connection connection) {
        // TODO Auto-generated constructor stub
        this.statusId = statusId;
        String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID = ?";
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, statusId);
            resultSet = statement.executeQuery();
            resultSet.next();
            status = resultSet.getString("REIMB_STATUS");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Something went wrong getting the reimbursement status");
        }

    }

}
