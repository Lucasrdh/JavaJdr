public class EquipementDefensif {
    private String nom;
    private String type;
    private int Defense;

    public EquipementDefensif(String personnageType) {
        if (personnageType.equals("Magicien")) {
            this.type = "Philtre";
            this.nom = "Armure de Mage";
            this.Defense = 10;
        } else if (personnageType.equals("Guerrier")) {
            this.type = "Bouclier";
            this.nom = "Bouclier en Bois";
            this.Defense = 10;
        }
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
        return Defense;
    }
    public void setDefense(int defense) {
        Defense = defense;
    }
    public String toString() {
        return nom + " " + "(Défense : "+ Defense + ")";
    }
}
