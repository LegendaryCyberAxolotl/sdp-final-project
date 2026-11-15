package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Warrior;
import dnd.decorator.SubclassDecorator;

public class TankDecorator extends SubclassDecorator {
    public TankDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Warrior)) {
            throw new IllegalArgumentException("Tank requires Warrior");
        }
    }
    @Override public String getSubclassName() { return "Tank"; }
    @Override protected String getSubclassDescription() { return "Defensive combat"; }
}
