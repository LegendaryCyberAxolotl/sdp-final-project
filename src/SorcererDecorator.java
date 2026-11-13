public class SorcererDecorator extends SubclassDecorator {
    public SorcererDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Mage)) {
            throw new IllegalArgumentException("Sorcerer requires Mage");
        }
    }
    @Override public String getSubclassName() { return "Sorcerer"; }
    @Override protected String getSpecialization() { return "Innate magic"; }
}
