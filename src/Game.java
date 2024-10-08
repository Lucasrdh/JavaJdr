import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import Case.*;

public class Game {
    private ArrayList<Case> plateau;

    private Menu menu;

    public Game(Menu menu) {
        this.menu = menu;
        ajouterTableau();
    }

    private void ajouterTableau() {
        for (int i = 0; i < 64; i++) {
            plateau.add(new CaseVide());
        }
     // plateau.add(new)

    }


    public int jouer_un_tour() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public void avancer(int pas) {
        positionJoueur += pas;
        if (positionJoueur > fin) {
            positionJoueur = fin;
        }
    }

    // Méthode pour vérifier si le joueur a gagné
    public boolean isGameWon() {
        return positionJoueur == fin;
    }

    // Le jeu commence ici
    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Le jeu commence !");

        while (!isGameWon()) {
            System.out.println("Appuie sur 'espace' pour lancer le dé, 'Q' pour quitter ou B pour voir les infos de ton perso !");
            String input = sc.nextLine();

            if (input.equals(" ")) {
                int resultatDe = jouer_un_tour();
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
