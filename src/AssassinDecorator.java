public class AssassinDecorator extends SubclassDecorator {
    public AssassinDecorator(CharacterClass wrappedClass) {
        super(wrappedClass);
        if (!(wrappedClass instanceof Rogue)) {
            throw new IllegalArgumentException("Assassin requires Rogue");
        }
    }
    @Override public String getSubclassName() { return "Assassin"; }
    @Override protected String getSpecialization() { return "Precision attacks"; }
}
