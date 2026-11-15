package dnd.bridge;

public class Human implements Race {
    private final int speed = 30;
    private final boolean hasNightVision = false;

    @Override
    public String getName() { return "Human"; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public boolean hasNightVision() { return hasNightVision; }
}
