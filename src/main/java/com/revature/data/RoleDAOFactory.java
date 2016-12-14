package com.revature.data;

import java.sql.Connection;

/**
 * Created by yehur on 12/13/2016.
 */
public class RoleDAOFactory {
    public static RoleDAO getInstance(Connection connection) {
        return new RoleDAOImplementation(connection);
    }
}
