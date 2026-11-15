package gear;

import dice.model.*;

public class Ranged extends Weapon {
    private int normalRange;
    private int maxRange;

    public Ranged(String name, int modifier, WeaponDamage damage, int normalRange, int maxRange) {
        super(name, modifier, damage, WeaponType.RANGED);
        this.normalRange = normalRange;
        this.maxRange = maxRange;
    }

}
