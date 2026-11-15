package dnd.bridge;

public class Dwarf implements Race {
    private final int speed = 25;
    private final boolean hasNightVision = true;

    @Override
    public String getName() { return "Dwarf"; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public boolean hasNightVision() { return hasNightVision; }
}
