
public class Personnage {
    private String type;
    private String nom;
    private int pv;
    private int attaque;
    private EquipementOffensif arme;
    private EquipementDefensif armure;

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

    public EquipementOffensif getEquipementOffensif() {
        return arme;
    }

    public EquipementDefensif getEquipementDefensif() {
        return armure;
    }

    public void setType(String type) {
        this.type = type;
        if (type.equals("Magicien")) {
            pv = 6;
            attaque = 15;
        } else if (type.equals("Guerrier")) {
            pv = 10;
            attaque = 10;

        }
        this.arme = new EquipementOffensif(type);
        this.armure = new EquipementDefensif(type);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public void setEquipementOffensif(EquipementOffensif equipementOffensif) {
        this.arme = equipementOffensif;
    }

    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.armure = equipementDefensif;
    }

    public String toString() {
        String myPersonnage = "Nom : " + nom + "\r\n";
        myPersonnage += "Pv : " + pv + "\r\n";
        myPersonnage += "Dommage : " + attaque + "\r\n";
        if (arme != null) {
            myPersonnage += "Weapon : " + arme.toString() + "\r\n";
           // myPersonnage += "Power : " + arme.getPuissance() + "\r\n";
        } else {
            myPersonnage += "Weapon : Mince ! Tu n'a plus d'arme ?!\r\n";
        }
        if (armure != null) {
            myPersonnage += "Armour : " + armure.toString() + "\r\n";
          //  myPersonnage += "Defense : " + armure.getDefense() + "\r\n";
        } else {
            myPersonnage += "Armour : Bah la c'est cringe frero !\r\n";
        }

        return myPersonnage;
    }

}

