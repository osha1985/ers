package com.revature.data;

import java.sql.Connection;

public class ReimbursementDAOFactory {
    public static ReimbursementDAO getInstance(Connection connection) {
        return new ReimbursementDAOImplementation(connection);
    }
}
