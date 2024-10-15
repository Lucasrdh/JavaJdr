package combat;

import personnages.Personnage;

/**
 * Interface représentant les actions de combat dans le jeu.
 * Elle définit les comportements que doivent implémenter les entités capables de combattre
 * comme les personnages et les monstres.
 */
public interface Combat {

    /**
     * Méthode permettant de lancer un combat contre un joueur.
     * Cette méthode sera utilisée pour gérer l'interaction entre un monstre et un joueur.
     *
     * @param joueur Le joueur qui participe au combat.
     */
    public void combattre(Personnage joueur);

    /**
     * Méthode permettant de recevoir une attaque. Elle est utilisée à la fois par les
     * personnages et les monstres lorsqu'ils subissent des dégâts d'une attaque.
     *
     * @param degats Les points de dégâts infligés par l'attaque reçue.
     */
    public void recevoirAttaque(int degats);
}
