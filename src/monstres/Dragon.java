package monstres;

import Case.Case;
import personnages.Personnage;

/**
 * Classe représentant un Dragon, un monstre puissant qui peut être rencontré dans le jeu.
 * Le Dragon hérite des caractéristiques d'un Monstre et peut interagir comme une case utilisable dans le jeu.
 */
public class Dragon extends Monstres implements Case {

    /**
     * Constructeur par défaut pour créer un Dragon avec des caractéristiques spécifiques.
     * Le Dragon possède 15 points de vie (HP), 4 points d'attaque, et est nommé "Dragun".
     */
    public Dragon() {
        super();
        this.setAttaque(4);
        this.setNom("Dragun");
        this.setType("Dragon");
        this.setHp(15);
    }

}
