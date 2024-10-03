import java.util.Scanner;

public class Menu {
    Scanner myPlayer = new Scanner(System.in);

    public Menu() {
        System.out.println("Welcome to the Menu");
        System.out.println("Would you like to play ?");
        System.out.println("Enter 1 to play !");
        System.out.println("Enter 2 to stay sad !");
    }

    public String dataName() {
        System.out.println("Quel est ton nom ?");
        String newName = myPlayer.nextLine();
        return newName;
    }
    public String dataType(String newName){

        System.out.println("Bienvenue " + newName + " Quel est ta classe ? ");
        String newType = myPlayer.nextLine();
        System.out.println("Tu est donc un " + newType + ".");
        return newType;
    }
}

