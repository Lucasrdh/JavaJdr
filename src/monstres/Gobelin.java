package monstres;

import Case.Case;
import personnages.Personnage;

public class Gobelin extends Monstres implements Case {

    public Gobelin() {
        super();
        this.setHp(6);
        this.setNom("Golbun");
        this.setAttaque(1);
        this.setType("Gobelin");
    }

    @Override
    public void utiliser(Personnage joueur) {

    }
}
