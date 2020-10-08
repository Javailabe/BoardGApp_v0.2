package DBconnections;

public class dbConn {

    private static String dbUrl = "jdbc:mysql://remotemysql.com:3306/Hrx91CNzZS";
    private static String adminUser = "Hrx91CNzZS";
    private static String adminPass = "4x4xuOk7aj";
    private static String gamesDB = "BoardG_games";
    private static String usersDB = "BoardG_users";
    private static String borrowsDB = "BoardG_borrows";

    public static String getDbUrl() {
        return dbUrl;
    }

    public static String getAdminUser() {
        return adminUser;
    }

    public static String getAdminPass() {
        return adminPass;
    }

    public static String getGamesDB() {
        return gamesDB;
    }

    public static String getUsersDB() {
        return usersDB;
    }

    public String getBorrowsDB() {
        return borrowsDB;
    }

}
