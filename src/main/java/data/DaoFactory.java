package data;

import configs.AdlisterConnection;

public class DaoFactory {
    private static AdsRepository adsRepositoryDao;
    private static UsersRepository usersRepositoryDao;
    private static MySQLCategoriesRepository mySQLCategoriesRepositoryDao;

    private static final AdlisterConnection connection = new AdlisterConnection();

    public static AdsRepository getAdsDao() {
        if (adsRepositoryDao == null) {
            adsRepositoryDao = new MySQLAdsRepositoryDao(connection);
        }
        return adsRepositoryDao;
    }

    public static UsersRepository getUsersDao() {
        if (usersRepositoryDao == null) {
            usersRepositoryDao = new MySQLUsersDaoRepository(connection);
        }
        return usersRepositoryDao;
    }

    public static MySQLCategoriesRepository getCategoriesDao() {
        if (mySQLCategoriesRepositoryDao == null) {
            mySQLCategoriesRepositoryDao = new MySQLCategoriesRepository(connection);
        }
        return mySQLCategoriesRepositoryDao;
    }
}
