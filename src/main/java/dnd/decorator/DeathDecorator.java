package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Cleric;
import dnd.decorator.SubclassDecorator;

public class DeathDecorator extends SubclassDecorator {
    public DeathDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Cleric)) {
            throw new IllegalArgumentException("Death requires Cleric");
        }
    }
    @Override public String getSubclassName() { return "Death"; }
    @Override protected String getSubclassDescription() { return "Death magic"; }
}
