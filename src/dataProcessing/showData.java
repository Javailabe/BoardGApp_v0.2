package dataProcessing;

import DBconnections.*;

import java.sql.*;

public class showData {

    private static String showSqlQerry = "SELECT * FROM ";
    private static String show ="";

    private static String getShow() {
        return showSqlQerry + show;
    }

    private static void showFromDB() {
        try {
            Connection connection = DriverManager.getConnection(dbConn.getDbUrl(),
                                                                dbConn.getAdminUser(),
                                                                dbConn.getAdminPass());
            Statement stmt = connection.createStatement();
            ResultSet show = stmt.executeQuery(getShow());

            while(show.next())
                System.out.println(show.getInt(1) + " "
                                 + show.getString(2) + " "
                                 + show.getString(3) + " "
                                 + show.getString(4));
            System.out.println();
            System.out.println("-----------------Koniec listy-----------------");

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String getShowSqlQerry() {
        return showSqlQerry;
    }

    public static void setShow(String showIntent) {
        show = showIntent;
    }

    public static void getShowFromDB() {
        showFromDB();
    }
}
