package equipement;

import Case.*;
import personnages.Personnage;

public class Philtre extends EquipementDefensif implements Case {
    public Philtre(String nom, int defense) {
        super();
        this.setDefense(defense);
        this.setNom(nom);
        this.setType("Philtre");
    }


    @Override
    public void utiliser(Personnage joueur) {
        if (joueur.getType().equals("Guerrier")) {
            System.out.println("Malheureusement, comme tu es un Guerrier, tu ne peux pas t'équiper du Philtre...");
        } else if (joueur.getType().equals("Magicien")) {
            joueur.equiperDefensif(this);
        }
    }

//    @Override
//    public String toString() {
//        return "Philtre{" +
//                "nom='" + getNom() + '\'' +
//                ", type='" + getType() + '\'' +
//                ", defense=" + getDefense() +
//                '}';
//    }

}



