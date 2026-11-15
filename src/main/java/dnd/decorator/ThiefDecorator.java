package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Rogue;
import dnd.decorator.SubclassDecorator;

public class ThiefDecorator extends SubclassDecorator {
    public ThiefDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Rogue)) {
            throw new IllegalArgumentException("Thief requires Rogue");
        }
    }
    @Override public String getSubclassName() { return "Thief"; }
    @Override protected String getSubclassDescription() { return "Stealing and stealth"; }
}
