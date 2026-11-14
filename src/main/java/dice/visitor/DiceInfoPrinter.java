package dice.visitor;

import dice.model.*;

public class DiceInfoPrinter implements DiceVisitor {
    @Override public int visitD4(D4 dice) { System.out.println("D4: Tetrahedron (daggers, small potions)."); return dice.getMaxValue(); }
    @Override public int visitD6(D6 dice) { System.out.println("D6: Cube (basic weapon damage)."); return dice.getMaxValue(); }
    @Override public int visitD8(D8 dice) { System.out.println("D8: Octahedron (longswords, spells)."); return dice.getMaxValue(); }
    @Override public int visitD10(D10 dice) { System.out.println("D10: Decahedron (heavy weapons, halberds)."); return dice.getMaxValue(); }
    @Override public int visitD12(D12 dice) { System.out.println("D12: Dodecahedron (barbarian axes)."); return dice.getMaxValue(); }
    @Override public int visitD20(D20 dice) { System.out.println("D20: Icosahedron (main dice for attacks and skill checks)."); return dice.getMaxValue(); }
    @Override public int visitD100(D100 dice) { System.out.println("D100: Percentage dice (tables, wild magic)."); return dice.getMaxValue(); }
}