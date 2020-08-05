package academy.belhard.game;

import academy.belhard.util.GameFieldPrintUtil;
import academy.belhard.util.GameStepUtil;
import academy.belhard.util.PrintCellUtil;

public class Game {
    private GameField gameField;
    private Gamer crossGamer;
    private Gamer zeroGamer;

    public Game(int size) {
        gameField = new GameField(size);
        crossGamer = new Gamer(gameField, true);
        zeroGamer = new Gamer(gameField, false);
    }

    public void start() {
        while (!isFinished()) {
            GameStepUtil.doStep(crossGamer, gameField);

            if (isFinished()) {
                break;
            }

            GameStepUtil.doStep(zeroGamer, gameField);
        }

        GameFieldPrintUtil.printField(gameField);
    }

    private boolean isFinished() {
        GameChecker gameChecker = new GameChecker(gameField);

        boolean draw = gameChecker.allFieldIsFilled();
        if (draw) {
            System.out.println("Ничья");
            return true;
        }

        Boolean result = gameChecker.checkWinner();

        if (result == null) {
            return false;
        }

        System.out.println("Победил " + PrintCellUtil.getCellLabel(result));
        return true;
    }
}
