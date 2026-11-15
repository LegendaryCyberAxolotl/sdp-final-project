package dnd.builder;

import dnd.bridge.CharacterClass;
import dnd.bridge.Cleric;
import dnd.bridge.Dwarf;
import dnd.bridge.Elf;
import dnd.bridge.Human;
import dnd.bridge.Mage;
import dnd.bridge.Orc;
import dnd.bridge.Race;
import dnd.bridge.Rogue;
import dnd.bridge.Warrior;
import dnd.config.CharacterOptions;
import dnd.decorator.ArcherDecorator;
import dnd.decorator.AssassinDecorator;
import dnd.decorator.DeathDecorator;
import dnd.decorator.DruidDecorator;
import dnd.decorator.LifeDecorator;
import dnd.decorator.LightDecorator;
import dnd.decorator.ScoutDecorator;
import dnd.decorator.SorcererDecorator;
import dnd.decorator.SwordsmanDecorator;
import dnd.decorator.TankDecorator;
import dnd.decorator.ThiefDecorator;
import dnd.decorator.WarlockDecorator;
import dnd.model.Character;
import gear.Weapon;

public class CharacterBuilder {
    private Race race;
    private CharacterClass characterClass;
    private Weapon weapon;

    public CharacterBuilder addRace(Race race) {
        this.race = race;
        return this;
    }

    public CharacterBuilder addClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
        return this;
    }

    public CharacterBuilder addWeapon(Weapon weapon) {
        this.weapon = weapon;
        return this;
    }

    public CharacterBuilder applyOptions(CharacterOptions options) {
        // race
        this.race = switch (options.race().toLowerCase()) {
            case "human" -> new Human();
            case "elf" -> new Elf();
            case "dwarf" -> new Dwarf();
            case "orc" -> new Orc();
            default -> throw new IllegalArgumentException("Unknown race: " + options.race());
        };

        // base character class
        CharacterClass baseClass = switch (options.characterClass().toLowerCase()) {
            case "warrior" -> new Warrior();
            case "mage" -> new Mage();
            case "rogue" -> new Rogue();
            case "cleric" -> new Cleric();
            default -> throw new IllegalArgumentException("Unknown class: " + options.characterClass());
        };

        this.characterClass = wrapSubclass(baseClass, options.subclass());
        return this;
    }

    private CharacterClass wrapSubclass(CharacterClass baseClass, String subclass) {
        if (subclass == null || subclass.equalsIgnoreCase("none")) {
            return baseClass;
        }
        return switch (subclass.toLowerCase()) {
            // Warrior subclasses
            case "archer" -> new ArcherDecorator(baseClass);
            case "swordsman" -> new SwordsmanDecorator(baseClass);
            case "tank" -> new TankDecorator(baseClass);
            // Mage subclasses
            case "druid" -> new DruidDecorator(baseClass);
            case "sorcerer" -> new SorcererDecorator(baseClass);
            case "warlock" -> new WarlockDecorator(baseClass);
            // Rogue subclasses
            case "thief" -> new ThiefDecorator(baseClass);
            case "assassin" -> new AssassinDecorator(baseClass);
            case "scout" -> new ScoutDecorator(baseClass);
            // Cleric subclasses
            case "life" -> new LifeDecorator(baseClass);
            case "death" -> new DeathDecorator(baseClass);
            case "light" -> new LightDecorator(baseClass);
            default -> throw new IllegalArgumentException("Unknown subclass: " + subclass);
        };
    }

    public Character build() {
        Character character = new Character(race, characterClass);
        if (weapon != null) {
            character.setWeapon(weapon);
        }
        return character;
    }
}