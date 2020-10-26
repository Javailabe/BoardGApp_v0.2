package dataProcessing;

import database.AdminClass;
import database.Games;
import database.Users;

import java.sql.*;
import java.util.Scanner;

public class Borrows {

    private static final String selectcountfrom = "SELECT * FROM ";
    private static final String where = " WHERE Name = ";
    private static final String and = " AND Surname = ";
    private static final String insertInto = "INSERT INTO ";
    private static final String values = " VALUES ";

    private static final String dbname = "`BoardG_borrows`"; //(`name`, `surname`, `game`, `quantity`)";
    private static final String sqldbname = "'BoardG_borrows'";

    private static String username, usersurname, game;  //czy to jest potrzebne?
    private static int quantity;

    public static String getDbname() {
        return dbname;
    }

    public static void checking() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj imie uzytownika: ");
        String username = scanner.nextLine();
        Users.setUserName(username);

        System.out.print("Podaj nazwisko uzytkownika: ");
        String usersurname = scanner.nextLine();
        Users.setUserSurname(usersurname);

        System.out.print("Podaj nazwe gry: ");
        String game = scanner.nextLine();
        Games.setName(game);

        System.out.print("Podaj ilosc do wypozyczenia: ");
        int quantity = (char) scanner.nextInt();
        System.out.println();

        duplicatecheck();
    }

    private static void duplicatecheck() {

        try {
            Connection connectionCheck = DriverManager.getConnection(AdminClass.getDbUrl(),
                                                                    AdminClass.getAdminUserName(),
                                                                    AdminClass.getAdminPassword());
            Statement stmtCheck = connectionCheck.createStatement();

                String checkduplicateuser = selectcountfrom + Users.getDbname() + where + Users.getUserName() + and + Users.getUserSurname();
                String checkduplicategame = selectcountfrom + Games.getDbname() + where + Games.getName();

            ResultSet rsu = stmtCheck.executeQuery(checkduplicateuser);
            boolean rsuflag = false;
            if (rsu.next() == true) {
                System.out.println("Uzytkownik " + Users.getUserName() + " " + Users.getUserSurname() + " istnieje.");
                rsuflag = true;
            }
            else
                System.out.println("Uzytkownik " + Users.getUserName() + " " + Users.getUserSurname() + " nie istnieje.");

            ResultSet rsg = stmtCheck.executeQuery(checkduplicategame);
            boolean rsgflag = false;
            if (rsg.next() == true) {
                System.out.println("Gra " + Games.getName() + " istnieje.");
                rsgflag = true;
            }
            else
                System.out.println("Gra " + Games.getName() + " nie istnieje.");
            System.out.println();

            if (rsuflag == true && rsgflag == true) {
                String addBorrowsstmt = insertInto + dbname + values + "(" + Users.getUserName() + "," +
                                                                             Users.getUserSurname() + "," +
                                                                             Games.getName() + "," +
                                                                             quantity + ")";
                Statement addstmt = connectionCheck.createStatement();
                PreparedStatement preparedStmt = connectionCheck.prepareStatement(addBorrowsstmt);
                preparedStmt.executeUpdate();

                System.out.println();
                System.out.println("Dodanow wpis do wypozyczen");
                System.out.println();
            }
            else
                System.out.println("Brakuje uzytkownika lub gry.");

            connectionCheck.close();

        }catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}
