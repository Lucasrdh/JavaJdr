package Personnages;

import Equipement.Philtre;
import Equipement.Sort;

public class Magicien extends Personnage {
    public Magicien(String nom) {
        super(nom, "Magicien");
        this.setAttaque(15);
        this.setPv(7);
        this.setPositionJoueur(0);
        this.setEquipementOffensif(new Sort());
        this.setEquipementDefensif(new Philtre());
    }
    public void ouSuisJe() {
        System.out.println("Je suis un Magicien qui avance dans le monde magique.");
    }
}
