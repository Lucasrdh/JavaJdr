package bonus;

import Case.Case;
import personnages.Personnage;

public class Potion extends Bonus implements Case {
    public Potion(String nom, int bonus) {
        super();
    this.setBonus(bonus);
    this.setType("Potion");
    this.setNom(nom);
    }

    @Override
    public void utiliser(Personnage joueur) {
        System.out.println("Ouah ! Une " + this.getNom() );

        int newPv = this.getBonus() + joueur.getPv();
        joueur.setPv(newPv);
        System.out.println("Vous gagné : " + this.getBonus() +" Points de vie ! Vous avez maintenant : " + joueur.getPv() + " HP");
    }
}
