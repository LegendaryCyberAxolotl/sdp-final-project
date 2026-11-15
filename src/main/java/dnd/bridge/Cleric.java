package dnd.bridge;
import dice.model.*;
import dice.visitor.*;

public class Cleric extends CharacterClass {
    private Dice hpDice = new D8();
    public String getName() { return "Cleric"; }
    public String getDescription() { return "Divine magic"; }

    public Dice getHpDice() {
        return hpDice;
    }
}
