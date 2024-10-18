package equipement;

import Case.*;
import personnages.Personnage;

/**
 * Classe représentant un Sort, un équipement offensif utilisable par les personnages Magiciens.
 * Un Sort augmente la puissance d'attaque du personnage.
 */
public class Sort extends EquipementOffensif implements Case {

    /**
     * Constructeur pour créer un Sort avec un nom et une valeur de puissance.
     *
     * @param nom      Le nom du Sort.
     * @param puissance La valeur de puissance attribuée par le Sort.
     */
    public Sort(String nom, int puissance) {
        super();
        this.setPuissance(puissance);
        this.setNom(nom);
        this.setType("Spell");
    }

    /**
     * Méthode pour utiliser le Sort. Si le personnage est un Magicien, il pourra s'équiper du Sort.
     * Si c'est un Guerrier, il ne pourra pas l'utiliser.
     *
     * @param joueur Le personnage qui tente d'utiliser le Sort.
     */
    @Override
    public void utiliser(Personnage joueur) {
        if (joueur.getType().equals("Guerrier")) {
            System.out.println("Malheureusement, comme tu es un Guerrier, tu ne peux pas t'équiper du Sort...");
        } else if (joueur.getType().equals("Magicien")) {
            joueur.equiperOffensif(this);
        }
    }
}
