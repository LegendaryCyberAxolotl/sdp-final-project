package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Warrior;
import dnd.decorator.SubclassDecorator;

public class ArcherDecorator extends SubclassDecorator {
    public ArcherDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Warrior)) {
            throw new IllegalArgumentException("Archer requires Warrior");
        }
    }
    @Override public String getSubclassName() { return "Archer"; }
    @Override protected String getSubclassDescription() { return "Ranged combat"; }
}
