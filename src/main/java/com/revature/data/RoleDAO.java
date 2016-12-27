package com.revature.data;

import com.revature.beans.Role;

/**
 * The interface Role dao.
 */
public interface RoleDAO {
    /**
     * Accepts the user's role id and returns a java bean containing information about the user's role.
     *
     * @param roleID The user's role id
     * @return A java bean containing information about the user's role
     */
    Role getRole(int roleID);
}
