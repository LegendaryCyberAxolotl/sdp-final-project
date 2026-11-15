package dice.model;

import dice.visitor.DiceVisitor;

public class D20 extends AbstractDice {
    public D20() { super(20, "D20"); }
    @Override public int accept(DiceVisitor visitor) { return visitor.visitD20(this); }
}