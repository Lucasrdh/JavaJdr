package Equipement;
import Case.*;
public class Arme extends EquipementOffensif implements Case {
    public Arme() {
        super();
        this.setNom("Epée");
        this.setType("Arme");
        this.setPuissance(5);
    }

    @Override
    public void utiliser() {

    }
}
