package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    // Retrieves an existing user from the `users` table using the email
    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by email", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

//gets the user user id
    @Override
    public User findUserById(String Id) {
        PreparedStatement stmt = null;
        try {
            String pullUser = "SELECT * from users WHERE id = ?";
            stmt = connection.prepareStatement(pullUser);
            stmt.setString(1, Id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractUser(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving your user.", e);
        }
    }

    @Override
    public User findById(String id) {
        String query = "SELECT * FROM users WHERE id = ? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by ID", e);
        }
    }

    public void updateUser(User user){
        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE users SET username=?, email=?, WHERE id=?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setLong(3, user.getId());
            stmt.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException("Error updating User Profile.");
        }
    }

    @Override
    public User getUserById(String id) {
        PreparedStatement stmt = null;
        String query = "SELECT * FROM users as a WHERE a.id = ?";
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractUser(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Ad could not be retrieved with ID", e);
        }
    }

    public User getUserById(Long id) {
        PreparedStatement stmt = null;
        String query = "SELECT * FROM users as a WHERE a.id = ?";
        try {
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractUser(rs);
        } catch (SQLException e) {
            throw new RuntimeException("User could not be retrieved with ID", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

    private User id(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

}
