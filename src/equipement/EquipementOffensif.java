package equipement;

public class EquipementOffensif {
    private String nom;
    private String type;
    private int puissance;


    public EquipementOffensif() {

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

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public String toString() {
        return nom + " " + "(Puissance : " + puissance + ")";
    }

}
