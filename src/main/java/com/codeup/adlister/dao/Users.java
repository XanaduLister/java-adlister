package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);

    // Retrieves an existing user from the `users` table using the email
    User findByEmail(String email);

    Long insert(User user);
    User findUserById(String Id);
}
