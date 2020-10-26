package dataProcessing;

import java.sql.*;
import java.util.Scanner;
import database.*;

public class AddData {

    private static final String insertInto = "INSERT INTO ";
    private static final String values = " VALUES ";

    public static void addnewintent(String intent) {
        Scanner scanner = new Scanner(System.in);

        if (intent == "user") {

            System.out.print("Podaj imie: ");
            String name = scanner.nextLine();
            Users.setUserName(name);

            System.out.print("Podaj nazwisko: ");
            String surname = scanner.nextLine();
            Users.setUserSurname(surname);

            System.out.print("Podaj email: ");
            String subemail = scanner.nextLine();
            Users.setEmail(subemail);

            sqladdquerry("user");
            System.out.println("Wpis dodany pomyslnie!");
        }
        else if (intent == "game") {

            System.out.print("Podaj nazwe: ");
            String subname = scanner.nextLine();
            Games.setName(subname);

            System.out.print("Podaj dostepna ilosc tej gry: ");
            int subavailableqty = scanner.nextInt();
            Games.setAvailableqty(subavailableqty);

            System.out.print("Podaj calkowita ilosc tej gry: ");
            int subtotalqty = scanner.nextInt();
            Games.setTotalqty(subtotalqty);

            sqladdquerry("game");
            System.out.println("Wpis dodany pomyslnie!");

        }
        else
            System.out.println("Blednie wskazany parametr");
    }

    private static void sqladdquerry(String intent) {

        if (intent == "user") {
            String useraddstmt = insertInto + Users.getDbname() + //" (" + Users.getColUserName() + "," +
                                                                  //       Users.getColUserSurname() + "," + //tyczasowo nie uzywane
                                                                  //       Users.getColUserEmail() + ") " +

                                 values + "(" + Users.getUserName() + "," +
                                                Users.getUserSurname() + "," +
                                                Users.getEmail() + ")";

            try {
                Connection connectionData = DriverManager.getConnection(AdminClass.getDbUrl(),
                                                                        AdminClass.getAdminUserName(),
                                                                        AdminClass.getAdminPassword());

                Statement stmtAdd = connectionData.createStatement();
                PreparedStatement preparedStmt = connectionData.prepareStatement(useraddstmt);
                preparedStmt.executeUpdate();

                connectionData.close();

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        else if (intent == "game") {
            String gameaddstmt = insertInto + Games.getDbname() + //" (" + Games.getSqlcolName() + "," +
                                                                  //       Games.getSqlcolAvailableQty() + "," + //tymczasowo nie uzywane
                                                                  //       Games.getsqlColTotalQty() + ") " +

                                 values + " (" + Games.getName() + "," +
                                                 Games.getAvailableqty() + "," +
                                                 Games.getTotalqty() + ")";

            try {
                Connection connectionData = DriverManager.getConnection(AdminClass.getDbUrl(),
                                                                        AdminClass.getAdminUserName(),
                                                                        AdminClass.getAdminPassword());

                Statement stmtAdd = connectionData.createStatement();
                PreparedStatement preparedStmt = connectionData.prepareStatement(gameaddstmt);
                preparedStmt.executeUpdate();

                connectionData.close();

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }
        else
            System.out.println("Argument został podany błędnie");
    }
}

