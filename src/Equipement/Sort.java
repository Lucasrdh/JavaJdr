package Equipement;
import Case.*;
public class Sort extends EquipementOffensif implements Case {
    public Sort() {
        super();
        this.setPuissance(5);
        this.setNom("Boule de feu");
        this.setType("Spell");
    }
    @Override
    public void utiliser() {

    }
}
