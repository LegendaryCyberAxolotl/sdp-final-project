public class Character {
    private final Race race;
    private final CharacterClass charClass;
    private final int level;
    public Character(Race race, CharacterClass charClass, int level) {
        if (race != charClass.getRace()) {
            throw new IllegalArgumentException("Race must match the class race");
        }
        this.race = race;
        this.charClass = charClass;
        this.level = level;
    }
    public void showInfo() {
        System.out.println("\n===== CHARACTER INFO =====");
        System.out.println("Race: " + charClass.getRaceInfo());
        System.out.println("Class: " + charClass.getName());
        System.out.println("Subclass: " + charClass.getSubclassName());
        System.out.println("Level: " + level);
        System.out.println("Specialization: " + charClass.getDescription());
        System.out.println("==========================");
    }
}
