package monstres;

import Case.Case;

public class Sorcier extends Monstres implements Case {

    public Sorcier() {
        super();
        this.setHp(9);
        this.setAttaque(2);
        this.setNom("Sorcun");
        this.setType("Sorcier");
    }

}
