import personnages.Guerrier;
import personnages.Magicien;
import personnages.Personnage;
import java.util.Scanner;

public class Menu {
    private Scanner myPlayer = new Scanner(System.in);

    public Menu() {
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
                return new Guerrier(newName);
            } else if (newType.equalsIgnoreCase("Magicien")) {
                return new Magicien(newName);
            } else {
                System.out.println("Eh cousin, écris Guerrier ou Magicien !");
            }
        }
    }

    public void infoDuJoueur(Personnage personnage1) {
        System.out.println(personnage1);
    }
}
