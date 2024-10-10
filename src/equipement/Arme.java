package equipement;
import Case.*;
import personnages.Personnage;

public class Arme extends EquipementOffensif implements Case {
    public Arme(String nom,int puissance) {
        super();
        this.setNom(nom);
        this.setType("Arme");
        this.setPuissance(puissance);
    }

    @Override
    public void utiliser(Personnage joueur) {
        if (joueur.getType().equals("Guerrier")) {
            joueur.equiperOffensif(this);
        } else if (joueur.getType().equals("Magicien")) {
            System.out.println("Malheureusement, comme tu es un Magicien, tu ne peux pas t'équiper de l'arme...");
        }
    }
}
