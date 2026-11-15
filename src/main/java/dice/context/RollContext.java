package dice.context;

public class RollContext {
    private final int modifier;
    private final boolean advantage;
    private final boolean disadvantage;

    public RollContext() {
        this(0, false, false);
    }

    public RollContext(int modifier) {
        this(modifier, false, false);
    }

    public RollContext(int modifier, boolean advantage, boolean disadvantage) {
        this.modifier = modifier;
        this.advantage = advantage;
        this.disadvantage = disadvantage;
    }

    public int getModifier() { return modifier; }
    public boolean hasAdvantage() { return advantage && !disadvantage; }
    public boolean hasDisadvantage() { return disadvantage && !advantage; }
}