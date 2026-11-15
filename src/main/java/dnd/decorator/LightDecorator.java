package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Cleric;
import dnd.decorator.SubclassDecorator;

public class LightDecorator extends SubclassDecorator {
    public LightDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Cleric)) {
            throw new IllegalArgumentException("Light requires Cleric");
        }
    }
    @Override public String getSubclassName() { return "Light"; }
    @Override protected String getSubclassDescription() { return "Radiant magic"; }
}
