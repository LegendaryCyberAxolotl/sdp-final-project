package dnd.bridge;
import dice.model.*;
import dice.visitor.*;

public class Warrior extends CharacterClass {
    private Dice hpDice = new D10();
    public String getName() { return "Warrior"; }
    public String getDescription() { return "Martial combat"; }

    public Dice getHpDice() {
        return hpDice;
    }
}
