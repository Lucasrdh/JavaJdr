package bonus;

import Case.Case;

/**
 * Classe abstraite représentant un bonus que le joueur peut obtenir.
 * Un bonus peut avoir un type, un nom, et une valeur spécifique qui influence les statistiques du joueur.
 */
public abstract class Bonus implements Case {
    private int bonus;
    private String type;
    private String nom;




    /**
     * Constructeur par défaut pour la classe Bonus.
     */
    public Bonus() {
        // Constructeur vide
    }

    /**
     * Définit le nom du bonus.
     * @param nom Le nom du bonus.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le nom du bonus.
     * @return Le nom du bonus.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur du bonus.
     * @param bonus La valeur du bonus (qui peut augmenter les statistiques du joueur).
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * Obtient la valeur du bonus.
     * @return La valeur du bonus.
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * Définit le type de bonus (ex. : offensif, défensif, etc.).
     * @param type Le type du bonus.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Obtient le type de bonus.
     * @return Le type de bonus.
     */
    public String getType() {
        return type;
    }
}
