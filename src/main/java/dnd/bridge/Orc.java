package dnd.bridge;

public class Orc implements Race {
    private final int speed = 30;
    private final boolean hasNightVision = false;

    @Override
    public String getName() { return "Orc"; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public boolean hasNightVision() { return hasNightVision; }
}
