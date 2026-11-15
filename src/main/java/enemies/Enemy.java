package enemies;

import java.util.List;
import java.util.ArrayList;

import dice.model.*;
import dice.visitor.*;
import dnd.model.*;

public class Enemy {
    private String name;
    private int hp;
    private Dice damage;
    private boolean alive;

    public static List<Enemy> getEnemies() {
        List<Enemy> enemies = new ArrayList<>();

        // New instances each time, so HP from a previous fight is not carried over
        enemies.add(new Enemy("Zombie", 15, new D6()));
        enemies.add(new Enemy("Skeleton", 15, new D8()));
        enemies.add(new Enemy("Barbarian", 30, new D8()));
        enemies.add(new Enemy("Wolf", 20, new D4()));
        enemies.add(new Enemy("Bear", 25, new D6()));

        return enemies;
    }

    public Enemy(String name, int hp, Dice damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.alive = true;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return hp;
    }

    public Dice getDamage() {
        return damage;
    }

    public void attack(dnd.model.Character targetCharacter) {
        DiceRoller roller = new DiceRoller();
        Dice d20 = new D20();

        int attackRoll = d20.accept(roller);

        int characterDefence = targetCharacter.getDefence();

        if (attackRoll == 20) {
            System.out.println(name + " makes critical attack!");
            int attackDamage = this.damage.accept(roller);
            attackDamage += this.damage.accept(roller);
            System.out.println("Damage: " + attackDamage);
            targetCharacter.takeDamage(attackDamage);
        } else if (attackRoll >= characterDefence) {
            System.out.println(name + " hits you!");
            int attackDamage = this.damage.accept(roller);
            System.out.println("Damage: " + attackDamage);
            targetCharacter.takeDamage(attackDamage);
        } else {
            System.out.println("You're lucky! " + name + " misses!");
        }

    }

    public void takeDamage(int damage) {
        hp -= damage;

        alive = checkAlive();
    }

    public boolean checkAlive() {
        return hp > 0;
    }
}
