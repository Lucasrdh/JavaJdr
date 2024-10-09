package Bonus;

import Case.Case;
import Personnages.Personnage;

import java.io.Serializable;

public class Potion extends Bonus implements Case {
    public Potion() {
        super();
    this.setBonus(3);
    this.setType("Potion");
    this.setNom("Potion simple");
    }

    @Override
    public void utiliser(Personnage joueur) {

    }
}
