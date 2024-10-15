package personnages;

import combat.Combat;
import equipement.EquipementDefensif;
import equipement.EquipementOffensif;

/**
 * Classe abstraite représentant un personnage dans le jeu.
 * Un personnage peut combattre, recevoir des attaques, et s'équiper d'armes et de protections.
 */
public abstract class Personnage implements Combat {
    private String type;
    private String nom;
    private int pv;
    private int attaque;
    private EquipementOffensif arme;
    private EquipementDefensif armure;

    /**
     * Constructeur pour créer un personnage avec un nom et un type spécifié.
     * @param nom Le nom du personnage.
     * @param type Le type du personnage (Guerrier, Magicien, etc.).
     */
    public Personnage(String nom, String type) {
        this.nom = nom;
        this.type = type;
        this.setType(type);
    }

    /**
     * Constructeur pour créer un personnage avec un nom, et par défaut de type Magicien.
     * @param nom Le nom du personnage.
     */
    public Personnage(String nom) {
        this(nom, "Magicien");
    }

    /**
     * Constructeur par défaut, créant un personnage nommé "lucas" de type Magicien.
     */
    public Personnage() {
        this("lucas");
    }

    /**
     * Méthode abstraite définissant la localisation du personnage sur le plateau.
     * Cette méthode devra être implémentée dans les classes dérivées.
     */
    public abstract void ouSuisJe();

    /**
     * Obtient le type du personnage.
     * @return Le type du personnage (Guerrier, Magicien, etc.).
     */
    public String getType() {
        return type;
    }

    /**
     * Définit le type du personnage.
     * @param type Le nouveau type du personnage.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Obtient le nom du personnage.
     * @return Le nom du personnage.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du personnage.
     * @param nom Le nouveau nom du personnage.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient les points de vie du personnage.
     * @return Les points de vie du personnage.
     */
    public int getPv() {
        return pv;
    }

    /**
     * Définit les points de vie du personnage.
     * @param pv Les nouveaux points de vie du personnage.
     */
    public void setPv(int pv) {
        this.pv = pv;
    }

    /**
     * Obtient les points d'attaque du personnage, en incluant la puissance de son arme.
     * @return Les points d'attaque totaux du personnage.
     */
    public int getAttaque() {
        return this.attaque + getEquipementOffensif().getPuissance();
    }

    /**
     * Définit les points d'attaque du personnage (hors arme).
     * @param attaque Les nouveaux points d'attaque du personnage.
     */
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    /**
     * Obtient l'équipement offensif du personnage (son arme).
     * @return L'arme actuellement équipée par le personnage.
     */
    public EquipementOffensif getEquipementOffensif() {
        return arme;
    }

    /**
     * Définit l'équipement offensif du personnage (son arme).
     * @param equipementOffensif La nouvelle arme à équiper.
     */
    public void setEquipementOffensif(EquipementOffensif equipementOffensif) {
        this.arme = equipementOffensif;
    }

    /**
     * Obtient l'équipement défensif du personnage (son armure).
     * @return L'armure actuellement équipée par le personnage.
     */
    public EquipementDefensif getEquipementDefensif() {
        return armure;
    }

    /**
     * Définit l'équipement défensif du personnage (son armure).
     * @param equipementDefensif La nouvelle armure à équiper.
     */
    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.armure = equipementDefensif;
    }

    /**
     * Applique les dégâts subis par le personnage en prenant en compte sa défense.
     * @param degats Les dégâts infligés par l'attaque.
     */
    @Override
    public void recevoirAttaque(int degats) {
        int defense = getEquipementDefensif().getDefense();
        int degatsSubis = degats - defense;
        if (degatsSubis < 0) {
            degatsSubis = 0;
        }
        this.pv -= degatsSubis;
    }

    /**
     * Méthode pour le combat contre un autre personnage.
     * À implémenter dans les sous-classes.
     * @param joueur Le personnage contre lequel se déroule le combat.
     */
    @Override
    public void combattre(Personnage joueur) {
        // À implémenter
    }

    /**
     * Équipe un objet défensif si sa défense est supérieure ou égale à l'équipement actuel.
     * @param equipement L'équipement défensif à équiper.
     */
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

    /**
     * Équipe un objet offensif si sa puissance est supérieure ou égale à l'équipement actuel.
     * @param equipement L'équipement offensif à équiper.
     */
    public void equiperOffensif(EquipementOffensif equipement) {
        if (isArmeCompatible(equipement)) {
            System.out.println("Ouah ! Vous trouvez : " + equipement.getNom() + " !");
            System.out.println("Sa puissance est de : " + equipement.getPuissance());

            if (this.getEquipementOffensif().getPuissance() <= equipement.getPuissance()) {
                System.out.println("Comme " + getArmeType() + " est meilleur tu t'en équipe !");
                this.setEquipementOffensif(equipement);
            } else if (this.getEquipementOffensif().getPuissance() >= equipement.getPuissance()) {
                System.out.println("Ton arme actuelle est plus puissante ! Tu t'équipe donc pas de : " + equipement.getNom() + " !");
            }
        }

    }

    /**
     * Méthode abstraite pour obtenir le type de défense utilisé par le personnage (ex. : bouclier).
     * À implémenter dans les sous-classes.
     * @return Le type de défense.
     */
    protected abstract String getDefenseType();

    /**
     * Méthode abstraite pour obtenir le type d'arme utilisé par le personnage (ex. : épée, sort).
     * À implémenter dans les sous-classes.
     * @return Le type d'arme.
     */
    protected abstract String getArmeType();

    /**
     * Vérifie si l'équipement défensif est compatible avec le personnage (ex. : bouclier pour un guerrier).
     * @param equipement L'équipement défensif à vérifier.
     * @return true si l'équipement est compatible, sinon false.
     */
    protected abstract boolean isDefenseCompatible(EquipementDefensif equipement);

    /**
     * Vérifie si l'équipement offensif est compatible avec le personnage (ex. : sort pour un magicien).
     * @param equipement L'équipement offensif à vérifier.
     * @return true si l'équipement est compatible, sinon false.
     */
    protected abstract boolean isArmeCompatible(EquipementOffensif equipement);

    /**
     * Redéfinit la méthode toString pour fournir une description complète du personnage, y compris ses points de vie, ses armes et son armure.
     * @return Une chaîne de caractères décrivant le personnage.
     */
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
}
