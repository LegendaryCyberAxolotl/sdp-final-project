package gear;

import dice.model.*;

public abstract class Weapon {
    protected String name;
    protected int modifier;
    protected WeaponDamage damage;
    protected WeaponType type;

    public static final Weapon weapon1 = new Melee("Sword", 0, new WeaponDamage(1, new D6()), 5);

    public Weapon(String name, int modifier, WeaponDamage damage, WeaponType type) {
        this.name = name;
        this.modifier = modifier;
        this.damage = damage;
        this.type = type;
    }

    public WeaponDamage getDamage() {
        return damage;
    }
}
