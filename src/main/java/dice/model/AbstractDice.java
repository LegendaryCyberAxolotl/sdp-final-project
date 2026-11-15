package dice.model;

public abstract class AbstractDice implements Dice {
    private final int maxValue;
    private final String name;

    protected AbstractDice(int maxValue, String name) {
        this.maxValue = maxValue;
        this.name = name;
    }

    @Override
    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMidValue() {
        return (int) (maxValue + 1) / 2;
    }
}