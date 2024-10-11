package combat;

import personnages.Personnage;

public interface Combat {

    public  void combattre(Personnage joueur);


    public void recevoirAttaque(int degats); // perso et monstre
}
