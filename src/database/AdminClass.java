package database;

public class AdminClass {

    private static final String dbUrl = "jdbc:mysql://remotemysql.com:3306/Hrx91CNzZS";
    private static final String adminUser = "Hrx91CNzZS";
    private static final String adminPass = "4x4xuOk7aj";

    public static String getDbUrl() {
        return dbUrl;
    }

    public static String getAdminUserName() {
        return adminUser;
    }

    public static String getAdminPassword() {
        return adminPass;
    }
}
