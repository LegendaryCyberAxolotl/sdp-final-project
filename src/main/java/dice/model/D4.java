package dice.model;

import dice.visitor.DiceVisitor;

public class D4 extends AbstractDice {
    public D4() { super(4, "D4"); }
    @Override public int accept(DiceVisitor visitor) { return visitor.visitD4(this); }
}