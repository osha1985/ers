package com.revature.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.AuthenticationException;

import com.revature.beans.Role;
import com.revature.beans.User;

public class UserDAOImplementation implements UserDAO {
    private Connection connection = null;

    @Override
    public User getByUsername(String userName) throws AuthenticationException {
        User user = new User();
        ResultSet resultSet;
        PreparedStatement statement;
        String sql = "SELECT * FROM (ERS_USERS u JOIN ERS_USER_ROLES e ON u.USER_ROLE_ID = e.ERS_USER_ROLE_ID) "
                + "WHERE ERS_USERNAME = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new AuthenticationException("The user does not exist");
            }
            user.setEmail(resultSet.getString("USER_EMAIL"));
            user.setFirstName(resultSet.getString("USER_FIRST_NAME"));
            user.setLastName(resultSet.getString("USER_LAST_NAME"));
            user.setPassword(resultSet.getString("ERS_PASSWORD"));
            user.setRole(new Role(resultSet.getInt("ERS_USER_ROLE_ID"), resultSet.getString("USER_ROLE")));
            user.setUserId(resultSet.getInt("ERS_USERS_ID"));
            user.setUsername(resultSet.getString("ERS_USERNAME"));
        } catch (SQLException e) {
            System.out.println("The username couldn't be accessed");
        }
        return user;
    }

    public void setConnection(Connection connection) {
        // TODO Auto-generated method stub
        if (this.connection == null) {
            this.connection = connection;
        }
    }

    @Override
    public Role getUserRole(String username) {
        // TODO Auto-generated method stub
        Role role = new Role();
        ResultSet resultSet;
        PreparedStatement statement;
        String sql = "SELECT USER_ROLE_ID, USER_ROLE FROM"
                + " (ERS_USERS JOIN ERS_USER_ROLES ON USER_ROLE_ID = ERS_USER_ROLE_ID) "
                + "WHERE ERS_USERNAME = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            resultSet.next();
            role.setUserRole(resultSet.getString("USER_ROLE"));
            role.setUserRoleId(resultSet.getInt("USER_ROLE_ID"));
        } catch (SQLException e) {
            System.out.println("The user role couldn't be accessed");
        }
        return role;

    }

}
