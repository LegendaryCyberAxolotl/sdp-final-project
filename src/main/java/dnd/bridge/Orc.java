package dnd.bridge;

public class Orc implements Race {
    private final int speed = 30;
    private final boolean hasNightVision = false;
    private final int hpModifier = 10;

    @Override
    public String getName() { return "Orc"; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public boolean hasNightVision() { return hasNightVision; }

    @Override
    public void showDescription() {
        System.out.println("Race: " + getName());
        System.out.println("Orcs are fierce and aggressive, known for their strength and combat skills.");
        System.out.println("Speed: " + getSpeed() + " feet per round");
        System.out.println("Night Vision: " + (hasNightVision ? "Yes" : "No"));
    }

    @Override
    public int getHpModifier() {
        return hpModifier;
    }
}
