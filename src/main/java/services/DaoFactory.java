package services;

import configs.AdlisterConnection;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;

    private static final AdlisterConnection connection = new AdlisterConnection();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(connection);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(connection);
        }
        return usersDao;
    }
}
