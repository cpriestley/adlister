package data;

import models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get a single ad by id
    Ad findAdById(long id);
    // get a list of ads by user id
    List<Ad> findAdsByUserId(long id);
}
