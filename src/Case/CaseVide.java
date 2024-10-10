package Case;

import personnages.Personnage;

public class CaseVide implements Case {

    @Override
    public void utiliser(Personnage joueur) {
        System.out.println("Il n'y y'a rien ici ! Je peux continuer !");

    }
}
