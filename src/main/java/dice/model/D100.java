package dice.model;

import dice.visitor.DiceVisitor;

public class D100 extends AbstractDice {
    public D100() { super(100, "D100"); }
    @Override public int accept(DiceVisitor visitor) { return visitor.visitD100(this); }
}