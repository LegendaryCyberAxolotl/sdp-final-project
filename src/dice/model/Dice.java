package dice.model;

import dice.visitor.DiceVisitor;

public interface Dice {
    int accept(DiceVisitor visitor);
    int getMaxValue();
    String getName();
}