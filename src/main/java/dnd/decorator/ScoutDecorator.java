package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Rogue;
import dnd.decorator.SubclassDecorator;

public class ScoutDecorator extends SubclassDecorator {
    public ScoutDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Rogue)) {
            throw new IllegalArgumentException("Scout requires Rogue");
        }
    }
    @Override public String getSubclassName() { return "Scout"; }
    @Override protected String getSubclassDescription() { return "Exploration and tracking"; }
}
