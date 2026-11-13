public class SwordsmanDecorator extends SubclassDecorator {
    public SwordsmanDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Warrior)) {
            throw new IllegalArgumentException("Swordsman requires Warrior");
        }
    }
    @Override public String getSubclassName() { return "Swordsman"; }
    @Override protected String getSpecialization() { return "Sword mastery"; }
}
