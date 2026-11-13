import java.util.Locale;

// Composes the existing Bridge and Decorator classes; not a Builder pattern.
public class CharacterCreator {
    public Character create(CharacterOptions options) {
        CharacterOptionsValidator.validate(options);
        Race race = createRace(options.race());
        CharacterClass base = createClass(options.characterClass(), race);
        CharacterClass decorated = decorate(options.subclass(), base);
        return new Character(race, decorated, 1);
    }
    private Race createRace(String name) {
        switch (name.toLowerCase(Locale.ROOT)) {
            case "human": return new Human();
            case "elf": return new Elf();
            case "dwarf": return new Dwarf();
            case "orc": return new Orc();
            default: throw new IllegalArgumentException("Unknown race: " + name);
        }
    }
    private CharacterClass createClass(String name, Race race) {
        switch (name.toLowerCase(Locale.ROOT)) {
            case "warrior": return new Warrior(race);
            case "mage": return new Mage(race);
            case "rogue": return new Rogue(race);
            case "cleric": return new Cleric(race);
            default: throw new IllegalArgumentException("Unknown class: " + name);
        }
    }
    private CharacterClass decorate(String name, CharacterClass base) {
        switch (name.toLowerCase(Locale.ROOT)) {
            case "archer": return new ArcherDecorator(base);
            case "swordsman": return new SwordsmanDecorator(base);
            case "tank": return new TankDecorator(base);
            case "druid": return new DruidDecorator(base);
            case "sorcerer": return new SorcererDecorator(base);
            case "warlock": return new WarlockDecorator(base);
            case "thief": return new ThiefDecorator(base);
            case "assassin": return new AssassinDecorator(base);
            case "scout": return new ScoutDecorator(base);
            case "life": return new LifeDecorator(base);
            case "death": return new DeathDecorator(base);
            case "light": return new LightDecorator(base);
            default: throw new IllegalArgumentException("Unknown subclass: " + name);
        }
    }
}
