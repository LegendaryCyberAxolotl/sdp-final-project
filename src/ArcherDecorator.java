public class ArcherDecorator extends SubclassDecorator {
    public ArcherDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Warrior)) {
            throw new IllegalArgumentException("Archer requires Warrior");
        }
    }
    @Override public String getSubclassName() { return "Archer"; }
    @Override protected String getSpecialization() { return "Ranged combat"; }
}
