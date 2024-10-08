import java.util.Random;
import java.util.Scanner;



public class Game {
    private int position;
    private final int fin = 64;
    private Menu menu;
    public Game(Menu menu) {
        this.position = 1;
        this.menu = menu;
    }

    // Méthode pour simuler le lancer de dé
    public int lancerDe() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // Méthode pour avancer le joueur
    public void avancer(int pas) {
        position += pas;
        if (position > fin) {
            position = fin;
        }
        System.out.println("Tu es maintenant sur la case " + position + ".");
    }

    // Méthode pour vérifier si le joueur a gagné
    public boolean isGameWon() {
        return position == fin;
    }

    // Le jeu commence ici
    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Le jeu commence !");

        while (!isGameWon()) {
            System.out.println("Appuie sur 'espace' pour lancer le dé, 'Q' pour quitter ou B pour voir les infos de ton perso !");
            String input = sc.nextLine();

            if (input.equals(" ")) {
                int resultatDe = lancerDe();
                System.out.println("Tu as lancé un " + resultatDe + ".");
                avancer(resultatDe);

                if (isGameWon()) {
                    System.out.println("Félicitations ! Tu as atteint la case 64 et gagné !");
                }

            } else if (input.equals("q")) {
                System.out.println("Tu as quitté la partie.");
                break;
            } else if (input.equals("B")) {
            menu.infoDuJoueur();

            } else {
                System.out.println("Appuie sur 'espace' pour lancer le dé.");
            }
        }
        sc.close();
    }
}
