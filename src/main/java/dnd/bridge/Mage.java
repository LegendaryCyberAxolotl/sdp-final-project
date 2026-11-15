package dnd.bridge;
import dice.model.*;
import dice.visitor.*;

public class Mage extends CharacterClass {
    private Dice hpDice = new D6();
    public String getName() { return "Mage"; }
    public String getDescription() { return "Arcane magic"; }

    public Dice getHpDice() {
        return hpDice;
    }
}
