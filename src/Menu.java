import java.util.Scanner;

public class Menu {
    Scanner myPlayer = new Scanner(System.in);
    Personnage personnage1 = new Personnage();

    public Menu() {
        System.out.println("Welcome to the Menu");
        System.out.println("Would you like to play ?");
        System.out.println("Enter 1 to play !");
        System.out.println("Enter 2 to stay sad !");
    }

    public String dataName() {
        System.out.println("Quel est ton nom ?");
        String newName = myPlayer.nextLine();
        personnage1 = new Personnage(newName);
        return newName;
    }

    public String dataType(String newName) {
        String newType;

        while (true) {
            System.out.println("Bienvenue " + newName + ". Quel est ta classe ? Un Guerrier ? Ou un Magicien ?");
             newType = myPlayer.nextLine();

            if (newType.equals("Guerrier") || newType.equals("Magicien")) {
                personnage1.setType(newType);
                break;
            } else {
                System.out.println("Eh cousin écrit Guerrier ou Magicien !");
            }
        }
        System.out.println("Tu est donc un " + newType + ".");
        personnage1.setType(newType);
        return newType;
    }

    public void infoJoueur(String newName, String newType) {
        System.out.println("Si tu est un " + newType + "," + newName + ", voici donc tes statistiques :" );

        System.out.println(personnage1);

       // System.out.println("Mais comme tu est un " + newType + ", je t'ai aussi donner de quoi te défendre ! " );

    }
//    public void getStarted (myPersonnage) {
//        System.out.println("Bon il serait temps de lancer la partie, Appuie sur 3 pour commencer, 4 si t'es un lache");
//
//
//    }
}

