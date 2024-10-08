package Equipement;
import Case.*;

public class Philtre extends EquipementDefensif implements Case {
    public Philtre() {
        super();
        this.setDefense(9);
        this.setNom("Armure de mage");
        this.setType("Philtre");
    }
    @Override
    public void utiliser() {

    }
}
