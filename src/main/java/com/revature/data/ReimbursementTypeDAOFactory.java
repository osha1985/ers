package com.revature.data;

import java.sql.Connection;

/**
 * Created by yehur on 12/13/2016.
 */
public class ReimbursementTypeDAOFactory {
        public static ReimbursementTypeDAO getInstance(Connection connection) {
            return new ReimbursementTypeDAOImplementation(connection);
        }
}
