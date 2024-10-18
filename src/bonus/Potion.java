package bonus;

import Case.Case;
import personnages.Personnage;

/**
 * Classe représentant une potion dans le jeu. Une potion est un type de bonus qui peut être utilisé pour augmenter les points de vie du joueur.
 * Elle implémente l'interface Case, ce qui signifie qu'elle peut être utilisée lorsqu'un joueur arrive sur la case contenant la potion.
 */
public class Potion extends Bonus {

    /**
     * Constructeur de la classe Potion.
     * @param nom Le nom de la potion.
     * @param bonus Le nombre de points de vie que la potion accorde au joueur.
     */
    public Potion(String nom, int bonus) {
        super();
        this.setBonus(bonus);
        this.setType("Potion");
        this.setNom(nom);
    }

    /**
     * Utilise la potion pour augmenter les points de vie du joueur.
     * @param joueur Le joueur qui utilise la potion.
     */
    @Override
    public void utiliser(Personnage joueur) {
        System.out.println("Ouah ! Une " + this.getNom() + " !");

        // Augmente les points de vie du joueur
        int newPv = this.getBonus() + joueur.getPv();
        joueur.setPv(newPv);

        System.out.println("Vous gagnez : " + this.getBonus() + " points de vie ! Vous avez maintenant " + joueur.getPv() + " HP.");
    }
}
