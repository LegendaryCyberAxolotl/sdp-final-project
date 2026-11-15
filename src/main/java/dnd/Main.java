package dnd;

import dnd.bridge.*;
import dnd.decorator.*;
import dnd.config.*;
import dnd.model.Character;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            CharacterOptions options = new CharacterOptionsSelector().selectOptions(scanner);
            CharacterOptionsValidator.validate(options);
            Main app = new Main();
            Race race = app.createRace(options.race());
            CharacterClass baseClass = app.createClass(options.characterClass());
            CharacterClass decoratedClass = app.decorate(options.subclass(), baseClass);
            Character character = new Character("Hero", race, decoratedClass,
                    decoratedClass.getHpDice().getMidValue() * race.getHpModifier());
            character.showInfo();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
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
    private CharacterClass createClass(String name) {
        switch (name.toLowerCase(Locale.ROOT)) {
            case "warrior": return new Warrior();
            case "mage": return new Mage();
            case "rogue": return new Rogue();
            case "cleric": return new Cleric();
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
