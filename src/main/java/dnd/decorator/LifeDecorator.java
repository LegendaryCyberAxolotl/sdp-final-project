package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Cleric;
import dnd.decorator.SubclassDecorator;

public class LifeDecorator extends SubclassDecorator {
    public LifeDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Cleric)) {
            throw new IllegalArgumentException("Life requires Cleric");
        }
    }
    @Override public String getSubclassName() { return "Life"; }
    @Override protected String getSubclassDescription() { return "Healing magic"; }
}
