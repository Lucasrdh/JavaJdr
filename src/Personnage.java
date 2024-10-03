
public class Personnage {
    private String type;
    private String nom;
    private int pv;
    private int attaque;
    private String EquipementOffensif;
    private String EquipementDefensif;

    public Personnage(String nom, String type) {
        this.nom = nom;
        this.type = type;
        if (type.equals("Magicien")) {
            pv = 6;
            attaque = 15;
        } else if (type.equals("Guerrier")) {
            pv = 10;
            attaque = 10;

        }
    }

    public Personnage(String nom) {
        this(nom, "Magicien");
    }

    public Personnage() {
        this("lucas");
    }

    public String getType() {
        return type;
    }

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getAttaque() {
        return attaque;
    }

    public String getEquipementOffensif() {
        return EquipementOffensif;
    }

    public String getEquipementDefensif() {
        return EquipementDefensif;
    }
}
