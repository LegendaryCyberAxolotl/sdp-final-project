public class TankDecorator extends SubclassDecorator {
    public TankDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Warrior)) {
            throw new IllegalArgumentException("Tank requires Warrior");
        }
    }
    @Override public String getSubclassName() { return "Tank"; }
    @Override protected String getSpecialization() { return "Defensive combat"; }
}
