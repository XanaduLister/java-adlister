package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> search(String searchTerm) {
        try {
            String insertQuery = "SELECT * FROM ads WHERE title LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            String searchTermWithWildcards = "%" + searchTerm + "%";
            stmt.setString(1, searchTermWithWildcards);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error searching ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, category) VALUES "
                + "(?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4, ad.getCategory());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public List<Ad> userAds(long id) {PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving your ads.", e);
        }
    }

    @Override
    public List<String> getAdCategories(long adId) {
        PreparedStatement stmt = null;
        List<String> adCategories = new ArrayList<>();
        try {
            String pullCategories = "SELECT type FROM categories JOIN ads_cat as ac ON categories.id = ac.category_id JOIN ads as a ON ac.ads_id = a.id WHERE a.id = ?";
            stmt = connection.prepareStatement(pullCategories);
            stmt.setLong(1, adId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                adCategories.add(rs.getString("type"));
            } return adCategories;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving your categories.", e);
        }
    }

    @Override
    public int getCategoryID (String category) {
        String query = "SELECT id from categories WHERE type = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException("Error getting category ID", e);
        }
    }

    @Override
    public void deleteAdByID(int adId) {
        String query = "DELETE from ads where id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, adId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ads", e);
        }
    }

    @Override
    public Ad getAdByID(String adId) {
        PreparedStatement stmt = null;
        try {
            String pullAdId = "SELECT * FROM ads where id = ?";
            stmt = connection.prepareStatement((pullAdId));
            stmt.setString(1, adId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving your ad.", e);
        }
    }

    public void update(Ad ad) {
        String query = "UPDATE ads SET title = ?, description = ?, category = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setString(3, ad.getCategory());
            stmt.setLong(4, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating your ad", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("category")
        );
    }

//test comment
    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
