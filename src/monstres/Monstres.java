package monstres;

import Case.Case;
import combat.Combat;
import personnages.Personnage;

/**
 * Classe abstraite représentant un monstre dans le jeu.
 * Les monstres peuvent combattre un joueur et recevoir des attaques.
 */
public abstract class Monstres implements Combat, Case {
    private String nom;
    private String type;
    private int attaque;
    private int hp;

    /**
     * Constructeur par défaut de la classe Monstres.
     */
    public Monstres() {

    }

    /**
     * Constructeur avec paramètres pour créer un monstre avec un nom, un type, une attaque et des points de vie (HP).
     *
     * @param nom Le nom du monstre.
     * @param type Le type du monstre (par exemple, "Dragon", "Gobelin").
     * @param attaque La valeur d'attaque du monstre.
     * @param hp Les points de vie du monstre.
     */
    public Monstres(String nom, String type, int attaque, int hp) {
        this.nom = nom;
        this.type = type;
        this.attaque = attaque;
        this.hp = hp;
    }

    /**
     * Réduit les points de vie du monstre en fonction des dégâts reçus.
     *
     * @param degats Le nombre de points de dégâts reçus.
     */
    @Override
    public void recevoirAttaque(int degats) {
        this.hp -= degats;
    }

    /**
     * Engage un combat entre le monstre et un joueur. Le joueur attaque d'abord,
     * puis le monstre riposte si le joueur n'a pas vaincu le monstre.
     *
     * @param joueur Le joueur avec lequel le monstre combat.
     */
    public void combattre(Personnage joueur) {
        System.out.println("Le combat commence contre un " + this.type + " nommé " + this.nom + " !!");
        recevoirAttaque(joueur.getAttaque());
        System.out.println(this.nom + " reçoit " + joueur.getAttaque() + " points de dégâts.");

        if (getHp() <= 0) {
            System.out.println("Vous avez vaincu " + this.nom + " le " + this.type + " !");
            return;
        }

        joueur.recevoirAttaque(getAttaque());
        System.out.println("Le joueur reçoit " + getAttaque() + " points de dégâts.");

        if (joueur.getPv() <= 0) {
            System.out.println("Vous avez été vaincu par " + this.nom + " le " + this.type + "...");
            System.exit(0);
        }
    }

    /**
     * Utilise le monstre sur le joueur, ce qui déclenche un combat.
     *
     * @param joueur Le joueur sur lequel le monstre est utilisé.
     */
    @Override
    public void utiliser(Personnage joueur) {
        combattre(joueur);
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public int getAttaque() {
        return attaque;
    }


    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }


    public int getHp() {
        return hp;
    }


    public void setHp(int hp) {
        this.hp = hp;
    }


    @Override
    public String toString() {
        String Monstre = "Je suis " + nom + "! \r\n";
        Monstre += "Le " + type + "! \r\n";
        return Monstre;
    }
}
