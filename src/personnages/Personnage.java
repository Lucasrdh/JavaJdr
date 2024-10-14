package personnages;

import combat.Combat;
import equipement.Arme;
import equipement.EquipementDefensif;
import equipement.EquipementOffensif;
import equipement.Philtre;

public abstract class Personnage implements Combat {
    private String type;
    private String nom;
    private int pv;
    private int attaque;
    private EquipementOffensif arme;
    private EquipementDefensif armure;

    public abstract void ouSuisJe();

    public Personnage(String nom, String type) {
        this.nom = nom;
        this.type = type;
        this.setType(type);
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
        return this.attaque + getEquipementOffensif().getPuissance();
    }

    public EquipementOffensif getEquipementOffensif() {
        return arme;
    }

    public EquipementDefensif getEquipementDefensif() {
        return armure;
    }

    public void setType(String type) {
        this.type = type;

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
        } else {
            myPersonnage += "Weapon : Mince ! Tu n'a plus d'arme ?!\r\n";
        }
        if (armure != null) {
            myPersonnage += "Armour  : " + armure.toString() + "\r\n";
        } else {
            myPersonnage += "Armour : Bah la c'est cringe frero !\r\n";
        }

        return myPersonnage;
    }

    @Override
    public void recevoirAttaque(int degats) {
        int defense = getEquipementDefensif().getDefense();
        int degatsSubis = degats - defense;
        if (degatsSubis < 0) {
            degatsSubis = 0;
        }
        this.pv -= degatsSubis;
    }

    @Override
    public void combattre(Personnage joueur) {

    }


    public void equiperDefensif(EquipementDefensif equipement) {
        if (isDefenseCompatible(equipement)) {
            System.out.println("Ouah ! Vous trouvez : " + equipement.getNom() + " !");
            System.out.println("Sa défense est de : " + equipement.getDefense());

            if (this.getEquipementDefensif().getDefense() <= equipement.getDefense()) {
                System.out.println("Comme ce " + getDefenseType() + " est meilleur tu t'en équipe !");
                this.setEquipementDefensif(equipement);

            } else if (this.getEquipementDefensif().getDefense() > equipement.getDefense()) {
                System.out.println("Ton " + getDefenseType() + " actuel est plus puissant ! Tu t'équipe donc pas de : " + equipement.getNom() + " !");
            }


        }
    }

    public void equiperOffensif(EquipementOffensif equipement) {
        if (isArmeCompatible(equipement)) {
            System.out.println("Ouah ! Vous trouvez : " + equipement.getNom() + " !");
            System.out.println("Sa puissance est de : " + equipement.getPuissance());

            if (this.getEquipementOffensif().getPuissance() <= equipement.getPuissance()) {
                System.out.println("Comme " + getArmeType() + " est meilleur tu t'en équipe !");
                this.setEquipementOffensif(equipement);
            } else if (this.getEquipementOffensif().getPuissance() >= equipement.getPuissance()) {
                System.out.println("Ton arme actuelle est plus puissant ! Tu t'équipe donc pas de : " + equipement.getNom() + " !");

            }
        }

    }

    protected abstract String getDefenseType();

    protected abstract String getArmeType();

    protected abstract boolean isDefenseCompatible(EquipementDefensif equipement);

    protected abstract boolean isArmeCompatible(EquipementOffensif equipement);
}

