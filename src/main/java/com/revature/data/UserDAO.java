package com.revature.data;
import com.revature.beans.User;

import javax.naming.AuthenticationException;

public interface UserDAO {
    User getByUsername(String username) throws AuthenticationException;
    User getByUserId(int userId) throws AuthenticationException;
}
