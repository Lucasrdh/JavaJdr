package monstres;

import Case.Case;
import combat.Combattant;
import personnages.Personnage;

/**
 * Classe abstraite représentant un monstre dans le jeu.
 * Les monstres peuvent combattre un joueur et recevoir des attaques.
 * Cette classe implémente les interfaces {@link Combattant} et {@link Case}.
 */
public abstract class Monstres implements Combattant, Case {
    private String nom;
    private String type;
    private int attaque;
    private int hp;

    /**
     * Constructeur par défaut de la classe Monstres.
     * Crée un monstre sans nom, type, attaque, ou points de vie initialisés.
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
     * Cela simule une interaction où le joueur rencontre un monstre et doit combattre.
     *
     * @param joueur Le joueur sur lequel le monstre est utilisé.
     */
    @Override
    public void utiliser(Personnage joueur) {
        combattre(joueur);
    }

    /**
     * Retourne le nom du monstre.
     *
     * @return Le nom du monstre.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du monstre.
     *
     * @param nom Le nom à attribuer au monstre.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le type du monstre.
     *
     * @return Le type du monstre (par exemple, "Dragon", "Gobelin").
     */
    public String getType() {
        return type;
    }

    /**
     * Définit le type du monstre.
     *
     * @param type Le type à attribuer au monstre.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retourne la valeur d'attaque du monstre.
     *
     * @return L'attaque du monstre.
     */
    public int getAttaque() {
        return attaque;
    }

    /**
     * Définit la valeur d'attaque du monstre.
     *
     * @param attaque La nouvelle valeur d'attaque du monstre.
     */
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    /**
     * Retourne les points de vie (HP) du monstre.
     *
     * @return Les points de vie restants du monstre.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Définit les points de vie (HP) du monstre.
     *
     * @param hp Le nombre de points de vie à attribuer au monstre.
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Retourne une représentation textuelle du monstre.
     * Cette représentation inclut le nom et le type du monstre.
     *
     * @return Une chaîne de caractères décrivant le monstre.
     */
    @Override
    public String toString() {
        String Monstre = "Je suis " + nom + "! \r\n";
        Monstre += "Le " + type + "! \r\n";
        return Monstre;
    }
}
