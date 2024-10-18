package personnages;

import equipement.EquipementDefensif;
import equipement.EquipementOffensif;
import equipement.Philtre;
import equipement.Sort;

/**
 * Classe représentant un Magicien dans le jeu.
 * Le Magicien est un personnage spécialisé dans l'utilisation de sorts offensifs
 * et de philtres défensifs. Il a des points de vie relativement faibles mais
 * compense avec une forte puissance d'attaque.
 */
public class Magicien extends Personnage {

    /**
     * Constructeur de la classe Magicien.
     * Initialise le Magicien avec un nom, 15 points d'attaque, 7 points de vie,
     * un sort "Petite boule de feu" comme arme et un philtre "Armure de papier" comme défense.
     *
     * @param nom Le nom du Magicien.
     */
    public Magicien(String nom) {
        super(nom, "Magicien");
        this.setAttaque(15); // Attaque élevée
        this.setPv(7); // PV relativement faibles
        this.setEquipementOffensif(new Sort("Petite boule de feu", 1)); // Sort par défaut
        this.setEquipementDefensif(new Philtre("Armure de papier", 1)); // Philtre par défaut
    }

    /**
     * Affiche la position ou la situation actuelle du Magicien.
     */
    public void ouSuisJe() {
        System.out.println("Je suis un Magicien qui avance dans le monde magique.");
    }

    /**
     * Retourne le type d'équipement défensif utilisé par le Magicien.
     *
     * @return Le type d'équipement défensif (dans ce cas, un Philtre).
     */
    @Override
    protected String getDefenseType() {
        return "Philtre";
    }

    /**
     * Retourne le type d'arme utilisée par le Magicien.
     *
     * @return Le type d'arme (dans ce cas, un Sort).
     */
    @Override
    protected String getArmeType() {
        return "ce Sort";
    }

    /**
     * Vérifie si l'équipement défensif est compatible avec le Magicien.
     * Le Magicien peut uniquement utiliser des philtres.
     *
     * @param equipement L'équipement défensif à vérifier.
     * @return True si l'équipement est un Philtre, sinon false.
     */
    @Override
    protected boolean isDefenseCompatible(EquipementDefensif equipement) {
        return equipement instanceof Philtre;
    }

    /**
     * Vérifie si l'arme est compatible avec le Magicien.
     * Le Magicien peut uniquement utiliser des sorts.
     *
     * @param equipement L'équipement offensif à vérifier.
     * @return True si l'équipement est un Sort, sinon false.
     */
    @Override
    protected boolean isArmeCompatible(EquipementOffensif equipement) {
        return equipement instanceof Sort;
    }

}
