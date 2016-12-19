package com.revature.beans;

import java.sql.Blob;
import java.sql.Timestamp;

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
    private Blob receipt;
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

    public Blob getReceipt() {
        return receipt;
    }

    public void setReceipt(Blob receipt) {
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
                         Blob receipt, User author, User resolver, ReimbursementStatus status, ReimbursementType type) {
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
}
