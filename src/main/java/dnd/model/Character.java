package dnd.model;

import dnd.bridge.CharacterClass;
import dnd.bridge.Race;
import actions.ActionStrategy;
import gear.Weapon;

public class Character {
    private String name;
    private final Race race;
    private final CharacterClass characterClass;
    private ActionStrategy action;
    private Weapon weapon;
    private int hp;
    private final int maxHp;
    private boolean alive;
    private int defence;
    private int defenceBonus;
    private int defaultDefence;
    private boolean defending;
    private boolean runs;

    public Character(String name, Race race, CharacterClass characterClass, int hp) {
        if (race == null || characterClass == null || name == null || name.isEmpty())
            throw new IllegalArgumentException("Race, class, and name are required");
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.hp = hp;
        this.maxHp = hp;
        this.alive = true;
        this.defaultDefence = 10;
        this.defence = defaultDefence;
        this.defenceBonus = 5;
        this.defending = false;
        this.runs = false;
    }

    public String getName() { return name; }
    public Race getRace() { return race; }
    public CharacterClass getCharacterClass() { return characterClass; }
    public ActionStrategy getAction() { return action; }
    public void setAction(ActionStrategy action) { this.action = action; }
    public Weapon getWeapon() { return weapon; }
    public void setWeapon(Weapon weapon) { this.weapon = weapon; }

    public int getHp() { return hp; }

    // Executes the currently selected action strategy
    public void performAction() {
        if (action != null) {
            action.act(this);
        }
    }

    // Restores HP to the maximum value (used after an encounter)
    public void restoreHp() {
        this.hp = maxHp;
        this.alive = true;
    }

    public void showInfo() {
        System.out.println("\n===== CHARACTER INFO =====");
        System.out.println("Name: " + name);
        System.out.println("Race: " + race.getName());
        System.out.println("Class: " + characterClass.getName());
        System.out.println("Subclass: " + characterClass.getSubclassName());
        System.out.println("Subclass description: " + characterClass.getDescription());
        System.out.println("HP: " + hp + "/" + maxHp);
        System.out.println("Weapon: " + (weapon == null ? "None" : weapon.getName()));
        System.out.println("==========================");
    }

    public boolean checkAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;

        this.alive = checkAlive();
    }

    public int getDefence() {
        return defence;
    }

    public void addDefence() {
        this.defence += defenceBonus;
        this.defending = true;
    }

    public void setDefaultDefence() {
        this.defence = this.defaultDefence;
        this.defending = false;
    }

    public boolean isDefending() {
        return this.defending;
    }

    public void runResult(boolean success) {
        this.runs = success;
    }

    public boolean hasRun() {
        return runs;
    }
}
