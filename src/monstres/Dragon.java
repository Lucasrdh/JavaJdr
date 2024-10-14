package monstres;

import Case.Case;
import personnages.Personnage;

public class Dragon extends Monstres implements Case {

    public Dragon() {
        super();
        this.setAttaque(4);
        this.setNom("Dragun");
        this.setType("Dragon");
        this.setHp(15);
    }


}
