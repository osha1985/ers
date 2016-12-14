package com.revature.data;

import java.sql.Connection;

/**
 * Created by yehur on 12/13/2016.
 */
public class ReimbursementStatusDAOFactory {
    public static ReimbursementStatusDAO getInstance(Connection connection) {
        return new ReimbursementStatusDAOImplementation(connection);
    }
}
