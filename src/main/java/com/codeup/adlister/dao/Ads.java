package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    List<Ad> search(String searchTerm);

    Long insert(Ad ad);
    // list all adds created by a specific user.
    List<Ad> userAds(long id);
    // gets a list of all categories assigned to an individual ad
    List<String> getAdCategories(long adId);

    Ad getAdByID(String adId);

    int getCategoryID (String category);

    void deleteAdByID(int id);
}
