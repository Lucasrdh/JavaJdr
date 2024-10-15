package equipement;

import Case.Case;
import personnages.Personnage;

/**
 * Classe représentant une arme dans le jeu.
 * Cette classe hérite de {@link EquipementOffensif} et implémente {@link Case}.
 * Elle permet au joueur de s'équiper d'une arme pour augmenter sa puissance offensive.
 */
public class Arme extends EquipementOffensif implements Case {

    /**
     * Constructeur de l'arme.
     * Initialise une nouvelle arme avec un nom et une puissance donnée.
     *
     * @param nom Le nom de l'arme.
     * @param puissance La puissance de l'arme, qui influencera les dégâts infligés en combat.
     */
    public Arme(String nom, int puissance) {
        super();
        this.setNom(nom);
        this.setType("Arme");
        this.setPuissance(puissance);
    }

    /**
     * Méthode permettant au joueur d'utiliser cette arme en l'équipant s'il est un Guerrier.
     * Si le joueur est un Magicien, il ne peut pas s'équiper de l'arme.
     *
     * @param joueur Le joueur qui utilise l'arme.
     */
    @Override
    public void utiliser(Personnage joueur) {
        if (joueur.getType().equals("Guerrier")) {
            joueur.equiperOffensif(this);
        } else if (joueur.getType().equals("Magicien")) {
            System.out.println("Malheureusement, comme tu es un Magicien, tu ne peux pas t'équiper de l'arme...");
        }
    }
}
