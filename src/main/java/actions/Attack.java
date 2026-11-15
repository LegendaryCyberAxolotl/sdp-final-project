package actions;

import dnd.model.Character;
import enemies.Enemy;
import gear.*;
import dice.model.*;
import dice.visitor.*;

public class Attack implements ActionStrategy {
    private final Enemy target;

    public Attack(Enemy target) {
        this.target = target;
    }

    @Override
    public void act(Character character) {
        Weapon weapon = character.getWeapon();
        DiceRoller roller = new DiceRoller();

        WeaponDamage damage = weapon.getDamage();

        System.out.println("Attacking with " + weapon.getName());

        int total = weapon.getModifier();
        for (int i = 0; i < damage.amount(); i++) {
            total += damage.dice().accept(roller);
        }

        System.out.println("You deal " + total + " damage to " + target.getName() + "!");
        target.takeDamage(total);
    }

}
