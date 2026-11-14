package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Mage;
import dnd.decorator.SubclassDecorator;

public class DruidDecorator extends SubclassDecorator {
    public DruidDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Mage)) {
            throw new IllegalArgumentException("Druid requires Mage");
        }
    }
    @Override public String getSubclassName() { return "Druid"; }
    @Override protected String getSubclassDescription() { return "Nature magic"; }
}
