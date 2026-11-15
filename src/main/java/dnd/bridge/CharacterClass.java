package dnd.bridge;
import dice.model.*;
import dice.visitor.*;

public abstract class CharacterClass {
    public abstract String getName();
    public String getSubclassName() { return "None"; }
    public String getDescription() { return ""; }
    public abstract Dice getHpDice();
}
