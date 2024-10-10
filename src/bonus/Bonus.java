package bonus;

public abstract class Bonus {
    private int bonus;
    private String type;
    private String nom;

    public Bonus() {

    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;

    }
}
