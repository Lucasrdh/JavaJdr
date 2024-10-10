package equipement;

import Case.*;
import personnages.Personnage;

public class Bouclier extends EquipementDefensif implements Case {
    public Bouclier(String nom, int defense) {
        super();
        this.setNom(nom);
        this.setType("Bouclier");
        this.setDefense(defense);
    }


    @Override
    public void utiliser(Personnage joueur) {
        if (joueur.getType().equals("Guerrier")) {
            joueur.equiperDefensif(this);
        } else if (joueur.getType().equals("Magicien")) {
            System.out.println("Malheureusement, comme tu es un Magicien, tu ne peux pas t'équiper du Bouclier...");
        }
    }
}
