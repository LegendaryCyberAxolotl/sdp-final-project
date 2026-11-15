import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import dnd.model.Character;
import dnd.bridge.*;
import dnd.decorator.*;
import dnd.builder.*;
import dice.model.*;
import dice.visitor.*;
import gear.*;
import enemies.*;
import actions.*;

public class Facade {
    private final List<Character> characters;
    private final Scanner scanner;

    public Facade(Scanner scanner) {
        this.characters = new ArrayList<>();
        this.scanner = scanner;
    }

    // Reads an integer in range [min, max] from the console, repeats until the input is valid
    private int readInt(int min, int max) {
        while (true) {
            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Input ended");
            }

            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }

            System.out.println("Invalid choice. Please enter a number from " + min + " to " + max + ".");
        }
    }

    // Reads a non-empty line from the console
    private String readNonEmptyLine() {
        while (true) {
            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Input ended");
            }

            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }

            System.out.println("Input cannot be empty. Try again.");
        }
    }

    // Asks a yes/no question and returns true for "y"
    private boolean readYesNo() {
        while (true) {
            String answer = readNonEmptyLine();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            }
            if (answer.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Please enter 'y' or 'n'.");
        }
    }

    // Returns the list of characters
    public List<Character> getCharacters() {
        return characters;
    }

    // Shows the list of all characters
    public void showCharacters() {
        if (characters.isEmpty()) {
            System.out.println("No characters created yet.");
            return;
        }

        for (Character character : characters) {
            character.showInfo();
        }
    }

    // Returns a list of characters that match the given name (case-insensitive)
    public List<Character> getCharactersByName(String name) {
        List<Character> found = new ArrayList<>();
        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                found.add(character);
            }
        }
        return found.isEmpty() ? null : found;
    }

    // Asks for a name and shows the characters that match it
    public void findCharacterByName() {
        if (characters.isEmpty()) {
            System.out.println("No characters created yet.");
            return;
        }

        System.out.println("Enter character name:");
        String name = readNonEmptyLine();
        showCharacterInfo(getCharactersByName(name));
    }

    // Shows the information of characters that match the given name
    public void showCharacterInfo(List<Character> characters) {
        if (characters == null) {
            System.out.println("Character not found.");
            return;
        }
        for (Character character : characters) {
            character.showInfo();
        }
    }

    // Prints available races and their descriptions, and returns the list of races
    public List<Race> getRaces() {
        List<Race> races = new ArrayList<>();
        races.add(new Human());
        races.add(new Elf());
        races.add(new Dwarf());
        races.add(new Orc());

        System.out.println("Available Races:");
        for (int i = 0; i < races.size(); i++) {
            System.out.println((i + 1) + ". " + races.get(i).getName());
            races.get(i).showDescription();
            System.out.println("===========================");
        }

        return races;
    }

    // Prints available classes and their descriptions, and returns the list of classes
    public List<CharacterClass> getClasses() {
        List<CharacterClass> classes = new ArrayList<>();
        classes.add(new Warrior());
        classes.add(new Mage());
        classes.add(new Rogue());
        classes.add(new Cleric());

        System.out.println("Available Classes:");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i).getName());
            System.out.println("Subclass: " + classes.get(i).getSubclassName());
            System.out.println("Description: " + classes.get(i).getDescription());
            System.out.println("===========================");
        }
        return classes;
    }

    // Prints available subclasses for a given class and returns the list of subclasses
    public List<SubclassDecorator> getSubclasses(CharacterClass characterClass) {
        List<SubclassDecorator> subclasses = new ArrayList<>();

        if (characterClass instanceof Warrior) {
            subclasses.add(new SwordsmanDecorator(characterClass));
            subclasses.add(new ArcherDecorator(characterClass));
            subclasses.add(new TankDecorator(characterClass));
        }

        if (characterClass instanceof Mage) {
            subclasses.add(new SorcererDecorator(characterClass));
            subclasses.add(new DruidDecorator(characterClass));
            subclasses.add(new WarlockDecorator(characterClass));
        }

        if (characterClass instanceof Rogue) {
            subclasses.add(new AssassinDecorator(characterClass));
            subclasses.add(new ScoutDecorator(characterClass));
            subclasses.add(new ThiefDecorator(characterClass));
        }

        if (characterClass instanceof Cleric) {
            subclasses.add(new LifeDecorator(characterClass));
            subclasses.add(new DeathDecorator(characterClass));
            subclasses.add(new LightDecorator(characterClass));
        }

        System.out.println("Available Subclasses for " + characterClass.getName() + ":");
        for (int i = 0; i < subclasses.size(); i++) {
            System.out.println((i + 1) + ". " + subclasses.get(i).getSubclassName());
            System.out.println("Description: " + subclasses.get(i).getDescription());
            System.out.println("===========================");
        }

        return subclasses;
    }

    // Creates a new character and adds it to the list of characters
    public void createCharacter() {
        CharacterBuilder builder = new CharacterBuilder();

        System.out.println("Enter character name:\n");
        String name = readNonEmptyLine();

        System.out.println("Choose a race by entering the corresponding number:\n");
        List<Race> races = getRaces();
        Race selectedRace = races.get(readInt(1, races.size()) - 1);
        System.out.println("You selected: " + selectedRace.getName());

        System.out.println("Choose a class by entering the corresponding number:\n");
        List<CharacterClass> classes = getClasses();
        CharacterClass selectedClass = classes.get(readInt(1, classes.size()) - 1);
        System.out.println("You selected: " + selectedClass.getName());

        System.out.println("Choose a subclass by entering the corresponding number:\n");
        List<SubclassDecorator> subclasses = getSubclasses(selectedClass);
        selectedClass = subclasses.get(readInt(1, subclasses.size()) - 1);
        System.out.println("You selected: " + selectedClass.getSubclassName());

        // Set hp
        System.out.println("Would you like to roll dices for HP? (y/n) If you choose 'n' the middle value will be used:\n");
        boolean rollHp = readYesNo();
        int hp = 0;
        DiceRoller roller = new DiceRoller();
        Dice hpDice = selectedClass.getHpDice();

        if (rollHp) {
            for (int i = 0; i < selectedRace.getHpModifier(); i++) {
                int result = hpDice.accept(roller);
                hp += result;
            }
        } else {
            hp = hpDice.getMidValue() * selectedRace.getHpModifier();
        }
        System.out.println("Your HP: " + hp);

        // Adds a weapon
        List<Weapon> weapons = Weapon.getWeapons();
        System.out.println("Choose a weapon by entering the corresponding number:\n");

        for (int i = 0; i < weapons.size(); i++) {
            System.out.println((i + 1) + ". " + weapons.get(i).getName());
            weapons.get(i).showInfo();
            System.out.println("===========================");
        }

        Weapon selectedWeapon = weapons.get(readInt(1, weapons.size()) - 1);
        System.out.println("You selected: " + selectedWeapon.getName());

        // Build the character
        Character character = builder.setName(name)
                .addRace(selectedRace)
                .addClass(selectedClass)
                .setHp(hp)
                .addWeapon(selectedWeapon)
                .build();

        characters.add(character);
        System.out.println("Character created successfully!");
    }

    // Selects a character by entering the corresponding number and returns the selected character
    public Character selectCharacter() {
        if (characters.isEmpty()) {
            System.out.println("No characters created yet.");
            return null;
        }

        System.out.println("Select a character by entering the corresponding number:\n");
        for (int i = 0; i < characters.size(); i++) {
            Character c = characters.get(i);
            System.out.println((i + 1) + ". " + c.getName() + " (" + c.getRace().getName() + " "
                    + c.getCharacterClass().getName() + ", " + c.getCharacterClass().getSubclassName() + ")");
        }

        Character selectedCharacter = characters.get(readInt(1, characters.size()) - 1);
        System.out.println("You selected: " + selectedCharacter.getName());

        return selectedCharacter;
    }

    // Runs a turn-based fight between the character and a random enemy
    public void encounter(Character character) {
        if (character == null) {
            return;
        }

        Random random = new Random();
        List<Enemy> enemies = Enemy.getEnemies();
        Enemy enemy = enemies.get(random.nextInt(enemies.size()));

        character.runResult(false);
        character.setAction(new StopDefending());
        character.performAction();

        System.out.println("Attention! There is a " + enemy.getName() + " against you!");

        while (character.checkAlive() && enemy.checkAlive()) {
            System.out.println("\n" + character.getName() + " HP: " + character.getHp()
                    + " | " + enemy.getName() + " HP: " + enemy.getHp());
            System.out.println("Your actions:");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Run");

            int actionChoice = readInt(1, 3);

            ActionStrategy action;
            switch (actionChoice) {
                case 1:
                    action = new Attack(enemy);
                    break;
                case 2:
                    action = new Defend();
                    break;
                default:
                    action = new AttemptToRun();
                    break;
            }

            character.setAction(action);
            character.performAction();

            if (actionChoice == 3) {
                if (character.hasRun()) {
                    System.out.println("You managed to escape!");
                    break;
                }
                System.out.println("You failed to escape!");
            }

            if (!enemy.checkAlive()) {
                break;
            }

            enemy.attack(character);

            // Defence only lasts for one enemy attack
            character.setAction(new StopDefending());
            character.performAction();
        }

        if (!character.checkAlive()) {
            System.out.println("\nYou were defeated by the " + enemy.getName() + "...");
        } else if (!enemy.checkAlive()) {
            System.out.println("\nVictory! The " + enemy.getName() + " is defeated!");
        }

        // The character fully rests after the encounter
        character.setAction(null);
        character.setDefaultDefence();
        character.restoreHp();
    }

    // Lets the user choose a character and starts an encounter with it
    public void startEncounter() {
        encounter(selectCharacter());
    }

}
