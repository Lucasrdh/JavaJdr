package Personnages;
import Equipement.Arme;
import Equipement.Bouclier;

public class Guerrier extends Personnage {

    public Guerrier(String nom) {
        super(nom, "Guerrier");
        this.setPv(10);
        this.setAttaque(10);
        this.setPositionJoueur(0);
        this.setEquipementOffensif(new Arme());
        this.setEquipementDefensif(new Bouclier());
    }
    public void ouSuisJe() {
        System.out.println("Je suis un Guerrier vaillant qui combat ses ennemis.");
    }
}

