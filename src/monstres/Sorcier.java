package monstres;

import Case.Case;

/**
 * Classe représentant un Sorcier dans le jeu.
 * Le Sorcier est un type de monstre qui hérite de la classe {@link Monstres}
 * et peut être utilisé comme une {@link Case} sur le plateau de jeu.
 */
public class Sorcier extends Monstres implements Case {

    /**
     * Constructeur par défaut de la classe Sorcier.
     * Initialise le Sorcier avec 9 points de vie, 2 points d'attaque, et un nom par défaut "Sorcun".
     */
    public Sorcier() {
        super();
        this.setHp(9); // Définit les points de vie du sorcier
        this.setAttaque(2); // Définit l'attaque du sorcier
        this.setNom("Sorcun"); // Définit le nom du sorcier
        this.setType("Sorcier"); // Définit le type du monstre comme "Sorcier"
    }
}
