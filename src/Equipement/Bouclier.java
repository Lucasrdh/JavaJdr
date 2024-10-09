package Equipement;
import Case.*;
import Personnages.Personnage;

public class Bouclier extends EquipementDefensif implements Case {
    public Bouclier() {
        super();
        this.setNom("Bouclier en Bois");
        this.setType("Bouclier");
        this.setDefense(10);
    }



    @Override
    public void utiliser(Personnage joueur) {

    }
}
