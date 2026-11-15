package actions;

import dnd.model.Character;
import gear.*;
import dice.model.*;
import dice.visitor.*;

public class Defend implements ActionStrategy {
    @Override
    public void act(Character character) {
        if (character.isDefending()) {
            System.out.println("You are already defending.");
            return;
        }

        character.addDefence();
        System.out.println("You raise your guard. Defence is now " + character.getDefence() + ".");
    }
}
