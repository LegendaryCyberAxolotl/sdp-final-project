package dnd.bridge;
import dice.model.*;
import dice.visitor.*;

public class Rogue extends CharacterClass {
    private Dice hpDice = new D8();
    public String getName() { return "Rogue"; }
    public String getDescription() { return "Stealth and agility"; }

    public Dice getHpDice() {
        return hpDice;
    }
}
