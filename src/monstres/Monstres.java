package monstres;

import Case.Case;
import combat.Combat;
import personnages.Personnage;

public abstract class Monstres implements Combat, Case {
    private String nom;
    private String type;
    private int attaque;
    private int hp;


    public Monstres() {

    }

    public Monstres(String nom, String type, int attaque, int hp) {
        this.nom = nom;
        this.type = type;
    }

    @Override
    public void recevoirAttaque(int degats) {
        this.hp -= degats;
    }

    public void combattre(Personnage joueur) {
        System.out.println("Le combat commence contre un " + this.type + " nommé " + this.nom + " !!");
        // Le joueur attaque le monstre
        recevoirAttaque(joueur.getAttaque());
        System.out.println(this.nom + " reçoit " + joueur.getAttaque() + " points de dégâts.");

        if (getHp() <= 0) {
            System.out.println("Vous avez vaincu " + this.nom + " le " + this.type + " !");
            return;
        }

        // Le monstre attaque le joueur
        joueur.recevoirAttaque(getAttaque());
        System.out.println("Le joueur reçoit " + getAttaque() + " points de dégâts.");

        if (joueur.getPv() <= 0) {
            System.out.println("Vous avez été vaincu par " + this.nom + " le " + this.type + "...");
            System.exit(0);
        }


    }

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

    public String toString() {
        String Monstre = "Je suis " + nom + "! \r\n";
        Monstre += "Le " + type + "! \r\n";
        return Monstre;
    }
}

