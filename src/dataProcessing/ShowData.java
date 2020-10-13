package dataProcessing;

import database.*;

import java.sql.*;

public class ShowData {

    public static void showFromDB(String dbaname) {

        String showSqlQerry = "SELECT * FROM " + dbaname;

        try {
            Connection connectionShow = DriverManager.getConnection(AdminClass.getDbUrl(),
                                                                    AdminClass.getAdminUserName(),
                                                                    AdminClass.getAdminPassword());

            Statement stmtShow = connectionShow.createStatement();
            ResultSet show = stmtShow.executeQuery(showSqlQerry);

            while(show.next())
                System.out.println(show.getString(1) + " "
                                 + show.getString(2) + " "
                                 + show.getString(3));
            System.out.println();
            System.out.println("-----------------Koniec listy-----------------");

            connectionShow.close();
        } catch (SQLException sqlexc) {
            sqlexc.printStackTrace();
        }
    }
}
