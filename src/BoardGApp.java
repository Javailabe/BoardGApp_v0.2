import dataProcessing.Borrows;
import dataProcessing.DeleteData;
import database.Games;
import database.Users;

import dataProcessing.AddData;
import dataProcessing.ShowData;
import dataProcessing.DeleteData.*;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class BoardGApp {

    boolean exit;

    public static void main(String args[]) throws FileNotFoundException {

        BoardGApp menu = new BoardGApp();
        menu.runMenu();
    }
        public void runMenu() throws FileNotFoundException {
            header();
            while (!exit) {
                menu();
                int input = menuInput();
                menuActions(input);
            }
        }

        private void header() {
            System.out.println();
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|                                                          |");
            System.out.println("|           Witaj w programie BoardG-App!                  |");
            System.out.println("|                                                          |");
            System.out.println("+----------------------------------------------------------+");
        }

        private void menu() {
            System.out.println();
            System.out.println("Wybierz jedna z ponizszych opcji aby wykonac rzadana operacje a nastepnie nacisnij ENTER:");
            System.out.println();
            System.out.println("        Wybierz (1) - Dodaj uzytkownika");
            System.out.println("        Wybierz (2) - Dodaj gre");
            System.out.println("        Wybierz (3) - Pokaz liste uzytkownikow");
            System.out.println("        Wybierz (4) - Pokaz liste gier");
            System.out.println("        Wybierz (5) - Usun uzytkownika");
            System.out.println("        Wybierz (6) - Usun gre");
            System.out.println("        Wybierz (7) - Dodaj wypozyczenie (prawie dziala)");
            System.out.println("        Wybierz (8) - Pokaz wypozyczenie");
            System.out.println("        Wybierz (0) - Zakoncz program");
            System.out.println();
        }

        private int menuInput() {

            int input = -1;
            Scanner keyboardInput = new Scanner(System.in);

            while (input < 0 || input > 9) {
                try {
                    System.out.print("Wybieram: ");
                    input = Integer.parseInt(keyboardInput.nextLine());
                } catch (NumberFormatException exception) {
                    System.out.println("Bledne wskazanie, wybierz ponownie z zakresu 0-7");
                }
            }
            return input;
        }

        private void menuActions (int input) throws FileNotFoundException {
            switch (input) {
                case 0:
                    exit = true;
                    System.out.println();
                    System.out.println(">>> Zamykanie programu <<<");
                    System.out.println();
                    break;
                case 1:
                    AddData.addnewintent("user");
                    break;
                case 2:
                    AddData.addnewintent("game");
                    break;
                case 3:
                    ShowData.showFromDB(Users.getDbname());
                    break;
                case 4:
                    ShowData.showFromDB(Games.getDbname());
                    break;
                case 5:
                    DeleteData.deleteintent("user");
                    break;
                case 6:
                    DeleteData.deleteintent("game");
                    break;
                case 7:
                    Borrows.checking();
                case 8:
                    ShowData.showFromDB(Borrows.getDbname());
            }
        }
    }


