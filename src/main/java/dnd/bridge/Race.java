package dnd.bridge;

public interface Race {
    String getName();
    int getSpeed();
    boolean hasNightVision();
    void showDescription();
    int getHpModifier();
}
