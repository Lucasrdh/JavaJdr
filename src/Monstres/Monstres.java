package Monstres;

public abstract class Monstres {
    private String nom;
    private String type;
    private int attaque;
    private int hp;

    public abstract void jeSersARien();

    public Monstres() {

    }

    public Monstres(String nom, String type, int attaque, int hp) {
        this.nom = nom;
        this.type = type;
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

