package monstres;

import Case.Case;
import personnages.Personnage;

/**
 * Classe représentant un Gobelin, un monstre faible mais agressif que les joueurs peuvent rencontrer dans le jeu.
 * Le Gobelin hérite des caractéristiques d'un Monstre.
 */
public class Gobelin extends Monstres {

    /**
     * Constructeur par défaut pour créer un Gobelin avec des caractéristiques spécifiques.
     * Le Gobelin possède 6 points de vie (HP), 1 point d'attaque, et est nommé "Golbun".
     */
    public Gobelin() {
        super();
        this.setHp(6);
        this.setNom("Golbun");
        this.setAttaque(1);
        this.setType("Gobelin");
    }

}
