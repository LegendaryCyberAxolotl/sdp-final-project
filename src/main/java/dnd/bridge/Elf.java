package dnd.bridge;

public class Elf implements Race {
    private final int speed = 35;
    private final boolean hasNightVision = true;

    @Override
    public String getName() { return "Elf"; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public boolean hasNightVision() { return hasNightVision; }
}
