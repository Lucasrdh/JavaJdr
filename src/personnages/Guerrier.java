package personnages;

import equipement.Arme;
import equipement.Bouclier;
import equipement.EquipementDefensif;
import equipement.EquipementOffensif;

/**
 * Classe représentant un Guerrier dans le jeu.
 * Le Guerrier est un personnage spécialisé dans l'utilisation des armes et des boucliers.
 * Il possède des points de vie (PV) élevés et une attaque puissante.
 */
public class Guerrier extends Personnage {

    /**
     * Constructeur de la classe Guerrier.
     * Initialise le Guerrier avec un nom, 10 points de vie, 10 points d'attaque,
     * une épée en bois comme arme et un bouclier en bois comme équipement défensif.
     *
     * @param nom Le nom du Guerrier.
     */
    public Guerrier(String nom) {
        super(nom, "Guerrier");
        this.setPv(10); // Définit les points de vie du guerrier
        this.setAttaque(10); // Définit l'attaque du guerrier
        this.setEquipementOffensif(new Arme("Epée en Bois", 1)); // Arme par défaut
        this.setEquipementDefensif(new Bouclier("Bouclier en Bois", 1)); // Bouclier par défaut
    }

    /**
     * Indique la position ou la situation actuelle du Guerrier.
     */
    public void ouSuisJe() {
        System.out.println("Je suis un Guerrier vaillant qui combat ses ennemis.");
    }

    /**
     * Retourne le type d'équipement défensif utilisé par le Guerrier.
     *
     * @return Le type d'équipement défensif (dans ce cas, un Bouclier).
     */
    @Override
    protected String getDefenseType() {
        return "Bouclier";
    }

    /**
     * Retourne le type d'arme utilisée par le Guerrier.
     *
     * @return Le type d'arme (dans ce cas, une Arme).
     */
    @Override
    protected String getArmeType() {
        return "cette Arme";
    }

    /**
     * Vérifie si l'équipement défensif est compatible avec le Guerrier.
     * Le Guerrier peut uniquement utiliser des boucliers.
     *
     * @param equipement L'équipement défensif à vérifier.
     * @return True si l'équipement est un bouclier, sinon false.
     */
    @Override
    protected boolean isDefenseCompatible(EquipementDefensif equipement) {
        return equipement instanceof Bouclier;
    }

    /**
     * Vérifie si l'arme est compatible avec le Guerrier.
     * Le Guerrier peut uniquement utiliser des armes.
     *
     * @param equipement L'équipement offensif à vérifier.
     * @return True si l'équipement est une arme, sinon false.
     */
    @Override
    protected boolean isArmeCompatible(EquipementOffensif equipement) {
        return equipement instanceof Arme;
    }

}
