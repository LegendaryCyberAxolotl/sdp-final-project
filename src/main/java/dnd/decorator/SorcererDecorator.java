package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Mage;
import dnd.decorator.SubclassDecorator;

public class SorcererDecorator extends SubclassDecorator {
    public SorcererDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Mage)) {
            throw new IllegalArgumentException("Sorcerer requires Mage");
        }
    }
    @Override public String getSubclassName() { return "Sorcerer"; }
    @Override protected String getSubclassDescription() { return "Innate magic"; }
}
