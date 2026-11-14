package dice.visitor;

import dice.context.RollContext;
import dice.model.*;

import java.util.Random;

public class DiceRoller implements DiceVisitor {
    private final Random random;
    private RollContext context;

    public DiceRoller() {
        this(new RollContext());
    }

    public DiceRoller(RollContext context) {
        this.random = new Random();
        this.context = context;
    }

    public void setContext(RollContext context) {
        this.context = context;
    }

    private int rollSingle(int max) {
        return random.nextInt(max) + 1;
    }

    private int executeStandardRoll(Dice dice) {
        int raw = rollSingle(dice.getMaxValue());
        int total = raw + context.getModifier();
        System.out.printf("[%s] Roll: %d (modifier: %+d) -> Total: %d%n",
                dice.getName(), raw, context.getModifier(), total);
        return total;
    }

    @Override public int visitD4(D4 dice) { return executeStandardRoll(dice); }
    @Override public int visitD6(D6 dice) { return executeStandardRoll(dice); }
    @Override public int visitD8(D8 dice) { return executeStandardRoll(dice); }
    @Override public int visitD10(D10 dice) { return executeStandardRoll(dice); }
    @Override public int visitD12(D12 dice) { return executeStandardRoll(dice); }

    @Override
    public int visitD20(D20 dice) {
        int roll1 = rollSingle(dice.getMaxValue());
        int chosen = roll1;

        if (context.hasAdvantage()) {
            int roll2 = rollSingle(dice.getMaxValue());
            chosen = Math.max(roll1, roll2);
            System.out.printf("[D20 with Advantage] Rolls: (%d, %d) -> Chosen: %d%n", roll1, roll2, chosen);
        } else if (context.hasDisadvantage()) {
            int roll2 = rollSingle(dice.getMaxValue());
            chosen = Math.min(roll1, roll2);
            System.out.printf("[D20 with Disadvantage] Rolls: (%d, %d) -> Chosen: %d%n", roll1, roll2, chosen);
        } else {
            System.out.printf("[D20] Rolled: %d%n", chosen);
        }

        if (chosen == 20) {
            System.out.println("  -> CRITICAL SUCCESS (Natural 20)!");
        } else if (chosen == 1) {
            System.out.println("  -> CRITICAL FAIL (Natural 1)!");
        }

        int total = chosen + context.getModifier();
        System.out.printf("  -> Check Total: %d%n", total);
        return total;
    }

    @Override
    public int visitD100(D100 dice) {
        int raw = rollSingle(dice.getMaxValue());
        System.out.printf("[D100 Percentage Roll] Rolled: %d%%%n", raw);
        return raw;
    }
}