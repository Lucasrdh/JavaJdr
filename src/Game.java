import java.util.*;

import Case.*;
import bonus.Potion;
import equipement.Arme;
import equipement.Sort;
import monstres.Dragon;
import monstres.Gobelin;
import monstres.Sorcier;
import personnages.Personnage;

public class Game {
    private ArrayList<Case> plateau;
    private Personnage joueur;
    private GameView gameView = new GameView();
    private Menu menu = new Menu();
    private Scanner sc = new Scanner(System.in);
    private int positionJoueur;

    public Game() {
        // Lancer la création du personnage ici
        this.joueur = creerPersonnage();
        this.positionJoueur = 0;
        ajouterTableau();
    }

    // Méthode pour créer le personnage via le menu
    private Personnage creerPersonnage() {
        String playerName = menu.dataName();
        return menu.dataType(playerName);
    }

    // Méthode pour ajouter les cases sur le plateau
    private void ajouterTableau() {
        plateau = new ArrayList<>();
        for (int i = 0; i <= 64; i++) {
            plateau.add(new CaseVide());
        }

        // Créer une liste des positions disponibles
        List<Integer> positionsLibre = new ArrayList<>();
        for (int i = 0; i <= 64; i++) {
            positionsLibre.add(i);
        }

        // Mélanger les positions pour qu'elles soient aléatoires
        Collections.shuffle(positionsLibre);

        // Ajouter ennemis et caisses surprises
        ajouterEnnemis(positionsLibre);
        ajouterCaisseSurprise(positionsLibre);
    }

    // Méthode pour ajouter les ennemis (dragons, sorciers, gobelins) sur le plateau
    private void ajouterEnnemis(List<Integer> positionsLibre) {
        // Ajouter les dragons
        for (int i = 0; i < 4; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Dragon());
        }

        // Ajouter les sorciers
        for (int i = 0; i < 10; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Sorcier());
        }

        // Ajouter les gobelins
        for (int i = 0; i < 10; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Gobelin());
        }
    }

    // Méthode pour ajouter les caisses surprises (armes, sorts, potions)
    private void ajouterCaisseSurprise(List<Integer> positionsLibre) {
        // Ajouter les massues
        for (int i = 0; i < 5; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Arme("Massue", 3));
        }

        // Ajouter les épées
        for (int i = 0; i < 4; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Arme("Épée", 10));
        }

        // Ajouter les sorts "éclair"
        for (int i = 0; i < 5; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Sort("Éclair", 15));
        }

        // Ajouter les sorts "boules de feu"
        for (int i = 0; i < 2; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Sort("Boules de feu", 25));
        }

        // Ajouter les potions standards
        for (int i = 0; i < 6; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Potion("Potion standard", 10));
        }

        // Ajouter les grandes potions
        for (int i = 0; i < 2; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Potion("Grande potion", 20));
        }
    }

    // Méthode pour jouer un tour (lancer un dé)
    public int jouer_un_tour() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // Méthode pour avancer le personnage sur le plateau
    public void avancer(int pas) {
        int nouvellePosition = positionJoueur + pas;
        if (nouvellePosition >= plateau.size()) {
            nouvellePosition = plateau.size() - 1;
        }
        positionJoueur = nouvellePosition;
        gameView.afficherPosition(nouvellePosition);

        // Utiliser la case où le joueur est arrivé
        Case caseActuelle = plateau.get(nouvellePosition);
        caseActuelle.utiliser(joueur);
    }

    // Vérifier si le joueur a gagné (atteint la dernière case)
    public boolean isGameWon() {
        return positionJoueur == plateau.size() - 1;
    }

    // Méthode principale pour démarrer le jeu
    public void start() {
        gameView.welcome();
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
                // Quitter la partie
                break;
            } else if (input.equals("b")) {
                // Afficher les informations du joueur
                menu.infoDuJoueur(joueur);
            } else {
                // Message d'erreur si autre chose est tapé
                gameView.concentre();
            }
        }
    }
}
