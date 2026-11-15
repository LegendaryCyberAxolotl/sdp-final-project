package actions;

import dnd.model.Character;
import gear.*;
import dice.model.*;
import dice.visitor.*;

public class StopDefending implements ActionStrategy {
    @Override
    public void act(Character character) {
        character.setDefaultDefence();
    }
}
