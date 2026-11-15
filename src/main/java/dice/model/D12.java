package dice.model;

import dice.visitor.DiceVisitor;

public class D12 extends AbstractDice {
    public D12() { super(12, "D12"); }
    @Override public int accept(DiceVisitor visitor) { return visitor.visitD12(this); }
}