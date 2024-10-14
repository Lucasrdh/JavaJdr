package personnages;

import equipement.EquipementDefensif;
import equipement.EquipementOffensif;
import equipement.Philtre;
import equipement.Sort;

public class Magicien extends Personnage {
    public Magicien(String nom) {
        super(nom, "Magicien");
        this.setAttaque(15);
        this.setPv(7);
        this.setEquipementOffensif(new Sort("Petite boule de feu", 1));
        this.setEquipementDefensif(new Philtre("Armure de papier", 1));
    }

    public void ouSuisJe() {
        System.out.println("Je suis un Magicien qui avance dans le monde magique.");
    }





    @Override
    protected String getDefenseType() {
        return "Philtre";
    }

    @Override
    protected String getArmeType() {
        return "ce Sort";
    }

    @Override
    protected boolean isDefenseCompatible(EquipementDefensif equipement) {
        return equipement instanceof Philtre;
    }

    @Override
    protected boolean isArmeCompatible(EquipementOffensif equipement) {
        return equipement instanceof Sort;
    }



}
