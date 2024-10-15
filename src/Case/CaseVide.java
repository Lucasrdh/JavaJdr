package Case;

import personnages.Personnage;

/**
 * Représente une case vide dans le jeu. Lorsqu'un joueur arrive sur cette case,
 * il n'y a pas d'effet particulier et le joueur peut continuer son aventure.
 */
public class CaseVide implements Case {

    /**
     * Méthode utilisée lorsqu'un joueur arrive sur une case vide.
     * Aucune action spéciale n'est déclenchée et le joueur peut continuer son chemin.
     *
     * @param joueur Le joueur qui utilise la case vide.
     */
    @Override
    public void utiliser(Personnage joueur) {
        System.out.println("Il n'y a rien ici ! Je peux continuer !");
    }
}
