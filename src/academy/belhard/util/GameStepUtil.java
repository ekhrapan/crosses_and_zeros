package academy.belhard.util;

import academy.belhard.exception.CellIsFilledException;
import academy.belhard.exception.CellIsOutOfFieldException;
import academy.belhard.game.GameField;
import academy.belhard.game.Gamer;

public class GameStepUtil {

    public static void doStep(Gamer gamer, GameField gameField) {
        boolean incorrectStep = true;

        while (incorrectStep) {
            GameFieldPrintUtil.printField(gameField);

            try {
                gamer.doAction();
                incorrectStep = false;
            } catch (CellIsFilledException | CellIsOutOfFieldException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
