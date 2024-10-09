package Monstres;

import Case.Case;
import Personnages.Personnage;

public class Gobelin extends Monstres implements Case {

    public Gobelin() {
        super();
        this.setHp(6);
        this.setNom("Golbun");
        this.setAttaque(1);
        this.setType("Gobelin");
    }


    @Override
    public void jeSersARien() {

    }

    @Override
    public void utiliser(Personnage joueur) {

    }
}
