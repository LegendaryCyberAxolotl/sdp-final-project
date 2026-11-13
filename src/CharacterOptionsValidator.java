public final class CharacterOptionsValidator {
    public static final String[] RACES = {"Human", "Elf", "Dwarf", "Orc"};
    public static final String[] CLASSES = {"Warrior", "Mage", "Rogue", "Cleric"};
    private static final String[][] SUBCLASSES = {
        {"Archer", "Swordsman", "Tank"},
        {"Druid", "Sorcerer", "Warlock"},
        {"Thief", "Assassin", "Scout"},
        {"Life", "Death", "Light"}
    };
    private CharacterOptionsValidator() { }
    public static int indexOf(String[] values, String target) {
        if (target == null) return -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i].equalsIgnoreCase(target)) return i;
        }
        return -1;
    }
    public static String[] subclassesFor(String charClass) {
        int index = indexOf(CLASSES, charClass);
        if (index < 0) throw new IllegalArgumentException("Unknown class: " + charClass);
        return SUBCLASSES[index].clone();
    }
    public static void validate(CharacterOptions options) {
        if (options == null) throw new IllegalArgumentException("Options cannot be null");
        if (indexOf(RACES, options.race()) < 0)
            throw new IllegalArgumentException("Unknown race: " + options.race());
        if (indexOf(CLASSES, options.characterClass()) < 0)
            throw new IllegalArgumentException("Unknown class: " + options.characterClass());
        if (indexOf(subclassesFor(options.characterClass()), options.subclass()) < 0)
            throw new IllegalArgumentException("Subclass " + options.subclass()
                + " is not available for " + options.characterClass());
    }
}
