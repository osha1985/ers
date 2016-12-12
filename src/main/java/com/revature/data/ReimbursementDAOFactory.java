package com.revature.data;
public class ReimbursementDAOFactory {
    public static ReimbursementDAO getInstance() {
        return new ReimbursementDAOImplementation();
    }
}
