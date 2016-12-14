package com.revature.data;

import java.sql.Connection;

public class UserDAOFactory {
    static UserDAO getInstance(Connection connection) {
        return new UserDAOImplementation(connection);
    }
}
