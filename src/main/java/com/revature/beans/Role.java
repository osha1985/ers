package com.revature.beans;
public class Role {
    @Override
    public String toString() {
        return "Role [userRoleId=" + userRoleId + ", userRole=" + userRole + "]";
    }
    private int userRoleId;
    private String userRole;
    public int getUserRoleId() {
        return userRoleId;
    }
    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    public Role(int userRoleId, String userRole) {
        this.userRoleId = userRoleId;
        this.userRole = userRole;
    }
    public Role() {
        super();
    }

}
