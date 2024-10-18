import personnages.Guerrier;
import personnages.Magicien;
import personnages.Personnage;
import java.util.Scanner;

/**
 * La classe Menu permet de gérer les interactions avec l'utilisateur pour la création de personnage.
 * Elle permet de récupérer le nom du joueur, de choisir sa classe (Guerrier ou Magicien),
 * et d'afficher les informations de ce personnage.
 */
public class Menu {
    private Scanner myPlayer = new Scanner(System.in);

    /**
     * Constructeur de la classe Menu.
     * Il initialise le scanner pour les interactions avec le joueur.
     */
    public Menu() {
    }

    /**
     * Demande à l'utilisateur d'entrer son nom.
     *
     * @return Le nom du joueur en tant que chaîne de caractères.
     */
    public String dataName() {
        System.out.println("Quel est ton nom ?");
        return myPlayer.nextLine();
    }

    /**
     * Demande au joueur de choisir une classe (Guerrier ou Magicien) et retourne une instance correspondante.
     * Si le joueur ne choisit pas une classe valide, le prompt est répété jusqu'à ce qu'une option valide soit choisie.
     *
     * @param newName Le nom du joueur.
     * @return Une instance de la classe Guerrier ou Magicien selon le choix du joueur.
     */
    public Personnage dataType(String newName) {
        String newType;

        // Boucle infinie jusqu'à ce que l'utilisateur entre une classe valide
        while (true) {
            System.out.println("Bienvenue " + newName + ". Quel est ta classe ? Un Guerrier ou un Magicien ?");
            newType = myPlayer.nextLine();

            // Si le joueur choisit Guerrier, on retourne une instance de Guerrier
            if (newType.equalsIgnoreCase("Guerrier")) {
                return new Guerrier(newName);
            }
            // Si le joueur choisit Magicien, on retourne une instance de Magicien
            else if (newType.equalsIgnoreCase("Magicien")) {
                return new Magicien(newName);
            }
            // Si le joueur entre un choix invalide, on demande à nouveau de choisir une classe
            else {
                System.out.println("Eh cousin, écris Guerrier ou Magicien !");
            }
        }
    }

    /**
     * Affiche les informations du personnage.
     *
     * @param personnage1 Le personnage dont les informations sont affichées.
     */
    public void infoDuJoueur(Personnage personnage1) {
        System.out.println(personnage1);
    }
}
