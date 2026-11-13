public class LightDecorator extends SubclassDecorator {
    public LightDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Cleric)) {
            throw new IllegalArgumentException("Light requires Cleric");
        }
    }
    @Override public String getSubclassName() { return "Light"; }
    @Override protected String getSpecialization() { return "Radiant magic"; }
}
