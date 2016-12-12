package com.revature.data;
import java.sql.Connection;

import javax.naming.AuthenticationException;

import com.revature.beans.Role;
import com.revature.beans.User;

public interface UserDAO {
    User getByUsername(String username) throws AuthenticationException;
    void setConnection(Connection connection);
    Role getUserRole(String username) throws AuthenticationException;

}
