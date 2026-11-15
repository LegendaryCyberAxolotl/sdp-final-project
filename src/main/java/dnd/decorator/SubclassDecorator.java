package dnd.decorator;

import dnd.bridge.CharacterClass;
import dice.model.Dice;

public abstract class SubclassDecorator extends CharacterClass {
    protected final CharacterClass wrappedClass;

    protected SubclassDecorator(CharacterClass wrappedClass) {
        if (wrappedClass == null) throw new IllegalArgumentException("Class is required");
        if (wrappedClass instanceof SubclassDecorator)
            throw new IllegalArgumentException("Only one subclass is allowed");
        this.wrappedClass = wrappedClass;
    }

    @Override public String getName() { return wrappedClass.getName(); }
    @Override public Dice getHpDice() { return wrappedClass.getHpDice(); }
    @Override public String getDescription() { return getSubclassDescription(); }
    protected abstract String getSubclassDescription();
}
