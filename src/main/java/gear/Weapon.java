package gear;

import java.util.List;
import java.util.ArrayList;

import dice.model.*;

public abstract class Weapon {
    protected String name;
    protected int modifier;
    protected WeaponDamage damage;
    protected WeaponType type;

    public static final Weapon sword = new Melee("Sword", 0, new WeaponDamage(1, new D6()));
    public static final Weapon axe = new Melee("Axe", 0, new WeaponDamage(1, new D8()));
    public static final Weapon hammer = new Melee("Hammer", 0, new WeaponDamage(1, new D6()));

    public static final Weapon lightBow = new Ranged("Light bow", 0, new WeaponDamage(1, new D8()), 60, 180);
    public static final Weapon heavyBow = new Ranged("Heavy bow", 0, new WeaponDamage(1, new D10()), 90, 270);
    public static final Weapon lightCrossbow = new Ranged("Light crossbow", 2, new WeaponDamage(1, new D8()), 60, 120);
    public static final Weapon heavyCrossbow = new Ranged("Heavy crossbow", 2, new WeaponDamage(1, new D10()), 100, 400);

    public static List<Weapon> getWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(sword);
        weapons.add(axe);
        weapons.add(hammer);
        weapons.add(lightBow);
        weapons.add(heavyBow);
        weapons.add(lightCrossbow);
        weapons.add(heavyCrossbow);
        return weapons;
    }

    public Weapon(String name, int modifier, WeaponDamage damage, WeaponType type) {
        this.name = name;
        this.modifier = modifier;
        this.damage = damage;
        this.type = type;
    }

    public WeaponDamage getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public int getModifier() {
        return modifier;
    }

    public abstract void showInfo();
}
