package Case;

import personnages.Personnage;

/**
 * Interface représentant une case dans le jeu. Chaque case peut être utilisée par un joueur,
 * ce qui peut déclencher différentes actions comme un combat, un bonus ou autre.
 */
public interface Case {

    /**
     * Méthode pour utiliser la case lorsqu'un joueur arrive dessus.
     * Chaque implémentation de cette méthode peut avoir un comportement différent (bonus, combat, etc.).
     *
     * @param joueur Le joueur qui utilise la case.
     */
    void utiliser(Personnage joueur);
}
