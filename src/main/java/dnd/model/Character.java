package dnd.model;

import dnd.bridge.CharacterClass;
import dnd.bridge.Race;
import actions.ActionStrategy;
import gear.Weapon;

public class Character {
    private final Race race;
    private final CharacterClass characterClass;
    private ActionStrategy action;
    private Weapon weapon;

    public Character(Race race, CharacterClass characterClass) {
        if (race == null || characterClass == null)
            throw new IllegalArgumentException("Race and class are required");
        this.race = race;
        this.characterClass = characterClass;
    }

    public Race getRace() { return race; }
    public CharacterClass getCharacterClass() { return characterClass; }
    public ActionStrategy getAction() { return action; }
    public void setAction(ActionStrategy action) { this.action = action; }
    public Weapon getWeapon() { return weapon; }
    public void setWeapon(Weapon weapon) { this.weapon = weapon; }

    public void showInfo() {
        System.out.println("\n===== CHARACTER INFO =====");
        System.out.println("Race: " + race.getName());
        System.out.println("Class: " + characterClass.getName());
        System.out.println("Subclass: " + characterClass.getSubclassName());
        System.out.println("Subclass description: " + characterClass.getDescription());
        System.out.println("==========================");
    }
}
