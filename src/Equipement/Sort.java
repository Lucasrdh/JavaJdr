package Equipement;
import Case.*;
import Personnages.Personnage;

public class Sort extends EquipementOffensif implements Case {
    public Sort() {
        super();
        this.setPuissance(5);
        this.setNom("Boule de feu");
        this.setType("Spell");
    }


    @Override
    public void utiliser(Personnage joueur) {

    }
}
