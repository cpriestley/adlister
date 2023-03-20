package data;

import models.Ad;

import java.util.List;

public interface AdsRepository {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    long insert(Ad ad);
    // get a single ad by id
    Ad findAdById(long id);
    // get a list of ads by user id
    List<Ad> findAdsByUserId(long id);
    int update(Ad ad);
    int delete(long id);
    List<Ad> search(String[] searchTerms);
}
