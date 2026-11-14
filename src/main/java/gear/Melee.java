package gear;

import dice.model.*;

public class Melee extends Weapon {
    private int range;

    public Melee(String name, int modifier, WeaponDamage damage, int range) {
        super(name, modifier, damage, WeaponType.MELEE);
        this.range = range;
    }
}
