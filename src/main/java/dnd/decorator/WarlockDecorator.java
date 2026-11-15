package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Mage;
import dnd.decorator.SubclassDecorator;

public class WarlockDecorator extends SubclassDecorator {
    public WarlockDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Mage)) {
            throw new IllegalArgumentException("Warlock requires Mage");
        }
    }
    @Override public String getSubclassName() { return "Warlock"; }
    @Override protected String getSubclassDescription() { return "Pact magic"; }
}
