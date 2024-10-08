import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        String choix = sc.nextLine();

        if (choix.equals("1")) {
            String playerName = menu.dataName();
            String playerType = menu.dataType(playerName);

            menu.infoJoueur(playerName, playerType);

            Game game = new Game(menu);
            game.start();
        } else if (choix.equals("2")) {
            System.out.println("So you have chosen.. death.");
            sc.close();
        }
    }
}