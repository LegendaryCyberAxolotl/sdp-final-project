package actions;

import dnd.model.Character;
import gear.*;
import dice.model.*;
import dice.visitor.*;

public class Attack implements ActionStrategy {
    @Override
    public void act(Character character) {
        Weapon weapon = character.getWeapon();
        DiceRoller roller = new DiceRoller();

        WeaponDamage damage = weapon.getDamage();

        System.out.println("Attacking with weapon");
        int roll = damage.dice().accept(roller);

        System.out.println("Result: " + roll);

    }

}
