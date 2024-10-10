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

    @Override
    public void utiliser(Personnage joueur) {
//ici logique de fight
        System.out.println("Vous tombez contre un monstre : " + this.getNom() + " !");


    }
}
