package equipement;

public class EquipementDefensif {
    private String nom;
    private String type;
    private int defense;

    public EquipementDefensif(String personnageType) {

    }

    public EquipementDefensif() {

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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String toString() {
        return nom + " " + "(Défense : " + defense + ")";
    }
}
