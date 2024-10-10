package personnages;

import equipement.Arme;
import equipement.Bouclier;
import equipement.EquipementDefensif;
import equipement.EquipementOffensif;

public class Guerrier extends Personnage {

    public Guerrier(String nom) {
        super(nom, "Guerrier");
        this.setPv(10);
        this.setAttaque(10);
        this.setPositionJoueur(0);
        this.setEquipementOffensif(new Arme("Epée en Bois", 2));
        this.setEquipementDefensif(new Bouclier("Bouclier en Bois", 3));
    }

    public void ouSuisJe() {
        System.out.println("Je suis un Guerrier vaillant qui combat ses ennemis.");
    }



    @Override
    protected String getDefenseType() {
        return "Bouclier";
    }

    @Override
    protected String getArmeType() {
        return "cette Arme";
    }

    @Override
    protected boolean isDefenseCompatible(EquipementDefensif equipement) {
        return equipement instanceof Bouclier;
    }

    @Override
    protected boolean isArmeCompatible(EquipementOffensif equipement) {
        return equipement instanceof Arme;
    }
}

