package com.revature.data;
public class UserDAOFactory {
    static UserDAO getInstance() {
        return new UserDAOImplementation();
    }
}
