public class DeathDecorator extends SubclassDecorator {
    public DeathDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Cleric)) {
            throw new IllegalArgumentException("Death requires Cleric");
        }
    }
    @Override public String getSubclassName() { return "Death"; }
    @Override protected String getSpecialization() { return "Death magic"; }
}
