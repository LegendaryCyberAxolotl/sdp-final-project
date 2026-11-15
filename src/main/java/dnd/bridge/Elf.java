package dnd.bridge;

public class Elf implements Race {
    private final int speed = 35;
    private final boolean hasNightVision = true;
    private final int hpModifier = 4;

    @Override
    public String getName() { return "Elf"; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public boolean hasNightVision() { return hasNightVision; }

    @Override
    public void showDescription() {
        System.out.println("Race: " + getName());
        System.out.println("Elves are graceful and long-lived, known for their keen senses and magical abilities.");
        System.out.println("Speed: " + getSpeed() + " feet per round");
        System.out.println("Night Vision: " + (hasNightVision ? "Yes" : "No"));
    }

    @Override
    public int getHpModifier() {
        return hpModifier;
    }
}
