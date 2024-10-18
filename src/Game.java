import java.lang.module.FindException;
import java.util.*;

import Case.*;
import bonus.Potion;
import equipement.Arme;
import equipement.Sort;
import monstres.Dragon;
import monstres.Gobelin;
import monstres.Sorcier;
import personnages.Personnage;

/**
 * Classe représentant la logique principale du jeu.
 * Cette classe gère la création du personnage, la génération du plateau de jeu,
 * les interactions avec les cases, et le déroulement des tours de jeu.
 */
public class Game {
    /**
     * Le plateau du jeu, constitué d'une liste de cases.
     */
    private ArrayList<Case> plateau;

    /**
     * Le personnage contrôlé par le joueur.
     */
    private Personnage joueur;

    /**
     * Vue du jeu pour afficher des messages à l'utilisateur.
     */
    private GameView gameView = new GameView();

    /**
     * Menu de démarrage et d'interaction avec le joueur.
     */
    private Menu menu = new Menu();

    /**
     * Scanner pour lire les entrées du joueur.
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * La position actuelle du joueur sur le plateau.
     */
    private int positionJoueur;

    /**
     * Constructeur de la classe Game.
     * Initialise le joueur et crée le plateau de jeu.
     */
    public Game() {
        this.joueur = creerPersonnage();
        this.positionJoueur = 0;
        ajouterTableau();
    }

    /**
     * Crée un personnage en demandant son nom et son type via le menu.
     * @return Le personnage créé.
     */
    private Personnage creerPersonnage() {
        String playerName = menu.dataName();
        return menu.dataType(playerName);
    }

    /**
     * Ajoute les cases sur le plateau.
     * Les cases peuvent être vides, contenir des ennemis ou des objets.
     */
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

        // Mélanger les positions pour les rendre aléatoires
        Collections.shuffle(positionsLibre);

        // Ajouter ennemis et objets
        ajouterEnnemis(positionsLibre);
        ajouterItems(positionsLibre);
    }

    /**
     * Ajoute des ennemis sur le plateau aux positions aléatoires.
     * Les ennemis sont des dragons, sorciers et gobelins.
     * @param positionsLibre Liste des positions disponibles sur le plateau.
     */
    private void ajouterEnnemis(List<Integer> positionsLibre) {
        // Ajouter des dragons
        for (int i = 0; i < 4; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Dragon());
        }

        // Ajouter des sorciers
        for (int i = 0; i < 10; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Sorcier());
        }

        // Ajouter des gobelins
        for (int i = 0; i < 10; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Gobelin());
        }
    }

    /**
     * Ajoute des items (armes, sorts, potions) sur le plateau aux positions aléatoires.
     * @param positionsLibre Liste des positions disponibles sur le plateau.
     */
    private void ajouterItems(List<Integer> positionsLibre) {
        // Ajouter des armes (massues et épées)
        for (int i = 0; i < 5; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Arme("Massue", 3));
        }
        for (int i = 0; i < 4; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Arme("Épée", 5));
        }

        // Ajouter des sorts
        for (int i = 0; i < 5; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Sort("Éclair", 2));
        }
        for (int i = 0; i < 2; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Sort("Boules de feu", 7));
        }

        // Ajouter des potions
        for (int i = 0; i < 6; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Potion("Potion standard", 2));
        }
        for (int i = 0; i < 2; i++) {
            int position = positionsLibre.remove(0);
            plateau.set(position, new Potion("Grande potion", 5));
        }
    }

    /**
     * Simule le lancer d'un dé pour déterminer le nombre de pas à avancer.
     * @return Un nombre entier entre 1 et 6.
     */
    public int jouer_un_tour() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    /**
     * Avance le joueur d'un certain nombre de cases, puis déclenche l'interaction avec la case actuelle.
     * Si le joueur atteint la fin du plateau, une exception de fin de jeu est lancée.
     * @param pas Le nombre de pas à avancer.
     * @throws FinDeJeuException Si le joueur atteint la dernière case et gagne la partie.
     */
    public void avancer(int pas) throws FinDeJeuException {
        int nouvellePosition = positionJoueur + pas;
        if (nouvellePosition >= plateau.size()) {
            nouvellePosition = plateau.size() - 1;
        }
        if (nouvellePosition == plateau.size() - 1) {
            throw new FinDeJeuException("You are the winner !");
        }
        positionJoueur = nouvellePosition;
        gameView.afficherPosition(nouvellePosition);

        // Utiliser la case où le joueur est arrivé
        Case caseActuelle = plateau.get(nouvellePosition);
        caseActuelle.utiliser(joueur);
    }

    /**
     * Vérifie si le joueur a gagné la partie (en atteignant la dernière case du plateau).
     * @return true si le joueur a gagné, false sinon.
     */
    public boolean isGameWon() {
        return positionJoueur == plateau.size() - 1;
    }

    /**
     * Démarre le jeu. Le jeu continue tant que le joueur n'a pas gagné ou quitté.
     */
    public void start(){
        gameView.welcome();
        while (true) {
            gameView.afficherTouche();
            String input = sc.nextLine();

            if (input.equals(" ")) {
                try {
                    int resultatDe = jouer_un_tour();
                    avancer(resultatDe);

                    // Si le joueur gagne, on sort de la boucle
                    if (isGameWon()) {
                        gameView.afficherVictoire();
                        break;
                    }
                } catch (FinDeJeuException e) {
                    gameView.afficherVictoire();
                    gameView.afficherFinJeu(e.getMessage());
                    break;
                }
            } else if (input.equals("q")) {
                // Quitter la partie
                break;
            } else if (input.equals("b")) {
                // Afficher les informations du joueur
                menu.infoDuJoueur(joueur);
            } else {
                gameView.concentre();
            }
        }
    }
}
