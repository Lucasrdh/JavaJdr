package Equipement;
import Case.*;
import Personnages.Personnage;

public class Philtre extends EquipementDefensif implements Case {
    public Philtre() {
        super();
        this.setDefense(9);
        this.setNom("Armure de mage");
        this.setType("Philtre");
    }


    @Override
    public void utiliser(Personnage joueur) {

    }
}
