package monstres;

import Case.Case;
import personnages.Personnage;

public class Sorcier extends Monstres implements Case {

    public Sorcier(){
        super();
        this.setHp(9);
        this.setAttaque(2);
        this.setNom("Sorcun");
        this.setType("Sorcier");
    }



    @Override
    public void utiliser(Personnage joueur) {
        System.out.println("un sorcier");
    }
}
