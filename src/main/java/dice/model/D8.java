package dice.model;

import dice.visitor.DiceVisitor;

public class D8 extends AbstractDice {
    public D8() { super(8, "D8"); }
    @Override public int accept(DiceVisitor visitor) { return visitor.visitD8(this); }
}