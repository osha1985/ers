package com.revature.beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;

    public User(int userId, String username, String password, String firstName, String lastName, String email,
                Role role) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;

    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
                + firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role + "]";
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(int userId, Connection connection) {
        // TODO Auto-generated constructor stub
        this.userId = userId;
        String sql = "SELECT * FROM"
                + " (ERS_USERS JOIN ERS_USER_ROLES ON ERS_USER_ROLE_ID = USER_ROLE_ID) "
                + "WHERE ERS_USERS_ID = ?";
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            System.out.println(userId);
            resultSet = statement.executeQuery();
            resultSet.next();
            this.username = resultSet.getString("ERS_USERNAME");
            this.password = resultSet.getString("ERS_PASSWORD");
            this.firstName = resultSet.getString("USER_FIRST_NAME");
            this.lastName = resultSet.getString("USER_LAST_NAME");
            this.email = resultSet.getString("USER_EMAIL");
            this.role = new Role(resultSet.getInt("ERS_USER_ROLE_ID"), resultSet.getString("USER_ROLE"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Something went wrong creating the user object from database data");
        }
    }

}
