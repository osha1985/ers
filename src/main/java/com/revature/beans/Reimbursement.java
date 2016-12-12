package com.revature.beans;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class Reimbursement {
    @Override
    public String toString() {
        return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
                + ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", resolver="
                + resolver + ", status=" + status + ", type=" + type + "]";
    }

    private int id;
    private double amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private InputStream receipt;
    private User author;
    private User resolver;
    private ReimbursementStatus status;
    private ReimbursementType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InputStream getReceipt() {
        return receipt;
    }

    public void setReceipt(InputStream receipt) {
        this.receipt = receipt;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getResolver() {
        return resolver;
    }

    public void setResolver(User resolver) {
        this.resolver = resolver;
    }

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
    }

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }

    public Reimbursement(int id, double amount, Timestamp submitted, Timestamp resolved, String description,
                         InputStream receipt, User author, User resolver, ReimbursementStatus status, ReimbursementType type) {
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.author = author;
        this.resolver = resolver;
        this.status = status;
        this.type = type;
    }

    public Reimbursement() {
        super();
    }

    public Reimbursement(String username, double amount, String description, String receipt, int typeId, String type, Connection connection) {
        // TODO Auto-generated constructor stub
        String sql = "SELECT * FROM"
                + " (ERS_USERS JOIN ERS_USER_ROLES ON  ERS_USERS_ID = ERS_USER_ROLE_ID)"
                + "WHERE ERS_USERNAME = ?";
        PreparedStatement statement;
        ResultSet resultSet;
        this.amount = amount;
        this.submitted = new Timestamp(new Date().getTime());
        this.description = description;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
            resultSet.next();
            this.author = new User(resultSet.getInt("ERS_USERS_ID"), username, resultSet.getString("ERS_PASSWORD"), resultSet.getString("USER_FIRST_NAME"), resultSet.getString("USER_LAST_NAME"), resultSet.getString("USER_EMAIL"), new Role(resultSet.getInt("ERS_USERS_ID"), resultSet.getString("USER_ROLE")));
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            System.out.println("Something went wrong reading into the reimbursement object");
        }
        this.resolver = null;
        this.status = new ReimbursementStatus(1, "Pending");
        this.type = new ReimbursementType(typeId, type);
        try {
            this.receipt = new FileInputStream(new File(receipt));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("The receipt could not be found");
        }

    }
}
