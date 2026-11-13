package dice.visitor;

import dice.model.*;

public interface DiceVisitor {
    int visitD4(D4 dice);
    int visitD6(D6 dice);
    int visitD8(D8 dice);
    int visitD10(D10 dice);
    int visitD12(D12 dice);
    int visitD20(D20 dice);
    int visitD100(D100 dice);
}