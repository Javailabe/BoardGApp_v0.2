package dataProcessing;

import database.AdminClass;
import database.Games;
import database.Users;

import java.sql.*;
import java.util.Scanner;

public class DeleteData {

    private static final String deletfrom = "DELETE FROM ";
    private static final String whereName = " WHERE Name = ";
    private static final String andSurname = " AND Surname = ";

    public static void deleteintent(String intent) {
        Scanner scanner = new Scanner(System.in);

        if (intent == "user") {

            System.out.println("Zdefiniuj uzytkownika, ktory zostanie usuniety przez podanie jego imienia oraz nazwiska");

            System.out.print("Podaj imie: ");
            String name = scanner.nextLine();
            Users.setUserName(name);

            System.out.print("Podaj nazwisko: ");
            String surname = scanner.nextLine();
            Users.setUserSurname(surname);

            sqldeletequerry("user");
            System.out.println("Uzytkownik zostal pomyslnie usuniety!");
        }
        else if (intent == "game") {

            System.out.print("Zdefinia gre, ktora zostanie usunieta podajac jej nazwe");

            System.out.print("Podaj nazwe: ");
            String subname = scanner.nextLine();
            Games.setName(subname);

            sqldeletequerry("game");
            System.out.print("Gra zostala pomyslnie usunieta");
        }
        else
            System.out.println("Blednie wskazany parametr");
    }

    private static void sqldeletequerry(String intent) {

        if (intent == "user") {
            String userdeletestmt = deletfrom + Users.getDbname() +
                                    whereName + Users.getUserName() + andSurname + Users.getUserSurname();

            try {
                Connection connectionData = DriverManager.getConnection(AdminClass.getDbUrl(),
                                                                        AdminClass.getAdminUserName(),
                                                                        AdminClass.getAdminPassword());

                Statement stmtAdd = connectionData.createStatement();
                PreparedStatement preparedStmt = connectionData.prepareStatement(userdeletestmt);
                preparedStmt.executeUpdate();

                connectionData.close();

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        else if (intent == "game") {
            String gamedeletestmt = deletfrom + Games.getDbname() + whereName + Games.getName();

            try {
                Connection connectionData = DriverManager.getConnection(AdminClass.getDbUrl(),
                                                                        AdminClass.getAdminUserName(),
                                                                        AdminClass.getAdminPassword());

                Statement stmtAdd = connectionData.createStatement();
                PreparedStatement preparedStmt = connectionData.prepareStatement(gamedeletestmt);
                preparedStmt.executeUpdate();

                connectionData.close();

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }
}
