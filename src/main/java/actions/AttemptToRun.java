package actions;

import java.util.Random;

import dnd.model.Character;
import gear.*;
import dice.model.*;
import dice.visitor.*;

public class AttemptToRun implements ActionStrategy {
    @Override
    public void act(Character character) {
        Random random = new Random();
        boolean success = random.nextInt(2) == 1 ? true : false;
        character.runResult(success);
    }
}
