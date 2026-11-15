package dice.model;

import dice.visitor.DiceVisitor;

public class D10 extends AbstractDice {
    public D10() { super(10, "D10"); }
    @Override public int accept(DiceVisitor visitor) { return visitor.visitD10(this); }
}