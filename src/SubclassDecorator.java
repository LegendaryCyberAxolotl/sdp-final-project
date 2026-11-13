public abstract class SubclassDecorator extends CharacterClass {
    protected final CharacterClass wrappedClass;
    protected SubclassDecorator(CharacterClass wrappedClass) {
        super(wrappedClass.getRace());
        if (wrappedClass instanceof SubclassDecorator) {
            throw new IllegalArgumentException("Only one subclass is allowed");
        }
        this.wrappedClass = wrappedClass;
    }
    @Override public String getName() { return wrappedClass.getName(); }
    @Override public String getRaceInfo() { return wrappedClass.getRaceInfo(); }
    @Override public String getDescription() {
        return wrappedClass.getDescription() + " | " + getSpecialization();
    }
    protected abstract String getSpecialization();
}
