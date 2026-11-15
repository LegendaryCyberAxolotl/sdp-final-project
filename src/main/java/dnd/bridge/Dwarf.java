package dnd.bridge;

public class Dwarf implements Race {
    private final int speed = 25;
    private final boolean hasNightVision = true;
    private final int hpModifier = 8;

    @Override
    public String getName() { return "Dwarf"; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public boolean hasNightVision() { return hasNightVision; }

    @Override
    public void showDescription() {
        System.out.println("Race: " + getName());
        System.out.println("Dwarves are sturdy and hardy, known for their resilience and craftsmanship.");
        System.out.println("Speed: " + getSpeed() + " feet per round");
        System.out.println("Night Vision: " + (hasNightVision ? "Yes" : "No"));
    }

    @Override
    public int getHpModifier() {
        return hpModifier;
    }
}
