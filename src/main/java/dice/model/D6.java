package dice.model;

import dice.visitor.DiceVisitor;

public class D6 extends AbstractDice {
    public D6() { super(6, "D6"); }
    @Override public int accept(DiceVisitor visitor) { return visitor.visitD6(this); }
}