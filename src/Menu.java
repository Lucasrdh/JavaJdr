import Personnages.Guerrier;
import Personnages.Magicien;
import Personnages.Personnage;

import java.util.Scanner;

public class Menu {
    private Scanner myPlayer = new Scanner(System.in);
    private Personnage joueur;

    public Menu() {
        System.out.println("Enter 1 to play !");
        System.out.println("Enter 2 to stay sad !");
    }

    public String dataName() {
        System.out.println("Quel est ton nom ?");
        return myPlayer.nextLine();
    }

    public Personnage dataType(String newName) {
        String newType;

        while (true) {
            System.out.println("Bienvenue " + newName + ". Quel est ta classe ? Un Guerrier ou un Magicien ?");
            newType = myPlayer.nextLine();

            if (newType.equalsIgnoreCase("Guerrier")) {
                joueur = new Guerrier(newName);
                break;
            } else if (newType.equalsIgnoreCase("Magicien")) {
                joueur = new Magicien(newName);
                break;
            } else {
                System.out.println("Eh cousin, écris Guerrier ou Magicien !");
            }
        }

        System.out.println("Tu es donc un " + newType + ".");
        return joueur;
    }

    public void infoJoueur(Personnage personnage1) {
        System.out.println("Voici tes statistiques :");
        System.out.println(personnage1);
    }

    public void infoDuJoueur() {
        System.out.println(joueur);
    }
}
