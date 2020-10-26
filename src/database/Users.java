package database;

public class Users {

    private static final String dbname = "BoardG_users";
    private static final String sqlDBname = "'BoardG_users'";

    //private static final String sqlcolUserName = "['Name']";
    //private static final String sqlcolUserSurname = "['Surname']";
    //private static final String sqlcolUserEmail = "['e-mail']";

    private static String userName, userSurname, email;

    public static String getDbname() {
        return dbname;
    }

    public static String getSqlDBname() {
        return sqlDBname;
    }

    //public static String getColUserName() {
    //    return sqlcolUserName;
    //}

    //public static String getColUserSurname() {
    //    return sqlcolUserSurname;
    //}

    //public static String getColUserEmail() {
    //    return sqlcolUserEmail;
    //}

    public static void setUserName(String name) {
        userName = name;
        setSqlUserName();
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserSurname(String surname) {
        userSurname = surname;
        setSqlUserSurname();
    }

    public static String getUserSurname() {
        return userSurname;
    }

    public static void setEmail(String subemail) {
        email = subemail;
        setSqlEmail();
    }

    public static String getEmail () {
        return email;
    }

    //metody zapisujace nazwy do formatu sql
    static void setSqlUserName() {
        userName = "'" + userName + "'";
    }

    static void setSqlUserSurname() {
        userSurname = "'" + userSurname + "'";
    }

    static void setSqlEmail() {
        email = "'" + email + "'";
    }
}
