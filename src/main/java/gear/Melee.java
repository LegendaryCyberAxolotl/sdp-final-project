package gear;

import dice.model.*;

public class Melee extends Weapon {
    private int range;

    public Melee(String name, int modifier, WeaponDamage damage) {
        super(name, modifier, damage, WeaponType.MELEE);
        this.range = 5;
    }

    @Override
    public void showInfo() {
        System.out.println("Weapon: " + name);
        System.out.println("Type: " + type);
        System.out.println("Modifier: " + modifier);
        System.out.println("Damage: " + damage.amount() + "D" + damage.dice().getMaxValue());
        System.out.println("Range: " + range + " feet");
    }
}
