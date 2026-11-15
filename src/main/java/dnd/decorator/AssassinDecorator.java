package dnd.decorator;

import dnd.bridge.CharacterClass;
import dnd.bridge.Rogue;
import dnd.decorator.SubclassDecorator;

public class AssassinDecorator extends SubclassDecorator {
    public AssassinDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Rogue)) {
            throw new IllegalArgumentException("Assassin requires Rogue");
        }
    }
    @Override public String getSubclassName() { return "Assassin"; }
    @Override protected String getSubclassDescription() { return "Precision attacks"; }
}
