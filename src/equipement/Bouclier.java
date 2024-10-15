package equipement;

import Case.Case;
import personnages.Personnage;

/**
 * Classe représentant un bouclier dans le jeu.
 * Cette classe hérite de {@link EquipementDefensif} et implémente {@link Case}.
 * Elle permet au joueur de s'équiper d'un bouclier pour augmenter sa défense.
 */
public class Bouclier extends EquipementDefensif implements Case {

    /**
     * Constructeur du bouclier.
     * Initialise un nouveau bouclier avec un nom et une défense donnée.
     *
     * @param nom Le nom du bouclier.
     * @param defense La valeur de la défense fournie par le bouclier.
     */
    public Bouclier(String nom, int defense) {
        super();
        this.setNom(nom);
        this.setType("Bouclier");
        this.setDefense(defense);
    }

    /**
     * Méthode permettant au joueur d'utiliser ce bouclier en l'équipant s'il est un Guerrier.
     * Si le joueur est un Magicien, il ne peut pas s'équiper du bouclier.
     *
     * @param joueur Le joueur qui utilise le bouclier.
     */
    @Override
    public void utiliser(Personnage joueur) {
        if (joueur.getType().equals("Guerrier")) {
            joueur.equiperDefensif(this);
        } else if (joueur.getType().equals("Magicien")) {
            System.out.println("Malheureusement, comme tu es un Magicien, tu ne peux pas t'équiper du Bouclier...");
        }
    }
}
