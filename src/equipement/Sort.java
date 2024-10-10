package equipement;
import Case.*;
import personnages.Personnage;

public class Sort extends EquipementOffensif implements Case {
    public Sort(String nom,int puissance ) {
        super();
        this.setPuissance(puissance);
        this.setNom(nom);
        this.setType("Spell");
    }


    @Override
    public void utiliser(Personnage joueur) {
        if (joueur.getType().equals("Guerrier")) {
            System.out.println("Malheureusement, comme tu es un Guerrier, tu ne peux pas t'équiper du Sort...");
        } else if (joueur.getType().equals("Magicien")) {
            joueur.equiperOffensif(this);
        }
    }

//    @Override
//    public int getPuissance() {
//        return super.getPuissance();
//    }
}
