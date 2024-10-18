package equipement;

import Case.*;
import personnages.Personnage;

/**
 * Classe représentant un Philtre, un type d'équipement défensif utilisable par les personnages Magiciens.
 * Un Philtre augmente la défense du personnage.
 */
public class Philtre extends EquipementDefensif implements Case {

    /**
     * Constructeur pour créer un Philtre avec un nom et une valeur de défense.
     *
     * @param nom     Le nom du Philtre.
     * @param defense La valeur de défense attribuée par le Philtre.
     */
    public Philtre(String nom, int defense) {
        super();
        this.setDefense(defense);
        this.setNom(nom);
        this.setType("Philtre");
    }

    /**
     * Méthode pour utiliser le Philtre. Si le personnage est un Magicien, il pourra s'équiper du Philtre.
     * Si c'est un Guerrier, il ne pourra pas l'utiliser.
     *
     * @param joueur Le personnage qui tente d'utiliser le Philtre.
     */
    @Override
    public void utiliser(Personnage joueur) {
        if (joueur.getType().equals("Guerrier")) {
            System.out.println("Malheureusement, comme tu es un Guerrier, tu ne peux pas t'équiper du Philtre...");
        } else if (joueur.getType().equals("Magicien")) {
            joueur.equiperDefensif(this);
        }
    }
}
