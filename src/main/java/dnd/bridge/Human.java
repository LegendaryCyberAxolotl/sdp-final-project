package dnd.bridge;

public class Human implements Race {
    private final int speed = 30;
    private final boolean hasNightVision = false;
    private final int hpModifier = 6;

    @Override
    public String getName() { return "Human"; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public boolean hasNightVision() { return hasNightVision; }

    @Override
    public void showDescription() {
        System.out.println("Race: " + getName());
        System.out.println("Humans are versatile and ambitious, known for their adaptability and resourcefulness.");
        System.out.println("Speed: " + getSpeed() + " feet per round");
        System.out.println("Night Vision: " + (hasNightVision ? "Yes" : "No"));
        System.out.println("HP Modifier: " + hpModifier);
    }

    @Override
    public int getHpModifier() {
        return hpModifier;
    }
}
