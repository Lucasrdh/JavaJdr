import java.util.Scanner;
import java.util.ArrayList;

import Case.*;
import bonus.Potion;
import equipement.Arme;
import equipement.Bouclier;
import equipement.Philtre;
import equipement.Sort;
import monstres.Dragon;
import monstres.Gobelin;
import monstres.Sorcier;
import personnages.Personnage;

public class Game {
    private ArrayList<Case> plateau;
    private Personnage joueur;
    private Menu menu;
    private GameView gameView = new GameView();

    public Game(Menu menu, Personnage joueur) {
        this.menu = menu;
        this.joueur = joueur;
        this.joueur.setPositionJoueur(0);
        ajouterTableau();

    }

    private void ajouterTableau() {
        plateau = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            plateau.add(new CaseVide());

        }
        plateau.add(new Potion("Potion rare", 5));
        plateau.add(new Philtre("Armure de gros bg",10));
        plateau.add(new Philtre("Armure de caca",2));
        plateau.add(new Bouclier("Bouclier en fer", 10));
        plateau.add(new Bouclier("Bouclier en caca", 5));
        plateau.add(new Arme("Epee en fer",10));
        plateau.add(new Arme("Epee en caca",2));
        plateau.add(new Sort("Boule de feu géante",15));
        plateau.add(new Sort("Boule de feu caca",15));
        plateau.add(new Dragon());
        plateau.add(new Gobelin());
        plateau.add(new Sorcier());

    }
///
    public int jouer_un_tour() {
//        Random random = new Random();
//        return random.nextInt(6) + 1;
        return 1;
    }


    public void avancer(int pas) {
        int nouvellePosition = joueur.getPositionJoueur() + pas;
        if (nouvellePosition >= plateau.size()) {
            nouvellePosition = plateau.size() - 1;
        }
        joueur.setPositionJoueur(nouvellePosition);
        gameView.afficherPosition(nouvellePosition);

        //Case caseActuelle: On crée une variable qui peut contenir n'importe quel type de case (grâce à l'interface).
        //plateau.get(nouvellePosition): On récupère la case à la position actuelle du joueur.
        //caseActuelle.utiliser(joueur): On appelle une méthode sur cette case, ce qui entraîne un comportement défini par le type spécifique de la case.

        Case caseActuelle = plateau.get(nouvellePosition);
        caseActuelle.utiliser(joueur);
    }

    // Méthode pour vérifier si le joueur a gagné
    public boolean isGameWon() {
        return joueur.getPositionJoueur() == plateau.size() -1;
    }

    // Le jeu commence ici
    public void start() {
        gameView.welcome();

        Scanner sc = new Scanner(System.in);
        while (!isGameWon()) {
            gameView.afficherTouche();
            String input = sc.nextLine();

            if (input.equals(" ")) {
                int resultatDe = jouer_un_tour();
                avancer(resultatDe);

                if (isGameWon()) {
                    gameView.afficherVictoire();
                    break;
                }

            } else if (input.equals("q")) {
                // quitter la partie
                break;
            } else if (input.equals("b")) {
                menu.infoDuJoueur();

            } else {
                gameView.concentre();
            }
        }
        sc.close();
    }
}
