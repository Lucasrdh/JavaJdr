package equipement;

/**
 * Classe représentant un équipement défensif dans le jeu.
 * Cette classe contient les propriétés générales des objets de défense comme les boucliers.
 */
public class EquipementDefensif {
    private String nom;
    private String type;
    private int defense;

    /**
     * Constructeur par défaut de la classe EquipementDefensif.
     * Initialise un équipement défensif avec des valeurs par défaut.
     */
    public EquipementDefensif() {

    }

    /**
     * Retourne le nom de l'équipement défensif.
     *
     * @return Le nom de l'équipement défensif.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'équipement défensif.
     *
     * @param nom Le nom à attribuer à l'équipement.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le type de l'équipement défensif.
     *
     * @return Le type de l'équipement.
     */
    public String getType() {
        return type;
    }

    /**
     * Définit le type de l'équipement défensif.
     *
     * @param type Le type à attribuer à l'équipement.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retourne la valeur de défense de l'équipement défensif.
     *
     * @return La valeur de défense.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Définit la valeur de défense de l'équipement défensif.
     *
     * @param defense La valeur de défense à attribuer.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'équipement défensif,
     * comprenant son nom et sa valeur de défense.
     *
     * @return Une chaîne décrivant l'équipement défensif.
     */
    @Override
    public String toString() {
        return nom + " " + "(Défense : " + defense + ")";
    }
}
