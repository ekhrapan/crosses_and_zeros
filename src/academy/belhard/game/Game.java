package academy.belhard.game;

import academy.belhard.util.ConsoleReaderUtil;
import academy.belhard.util.PrintCellUtil;
import academy.belhard.exception.CellIsFilledException;
import academy.belhard.exception.CellIsOutOfFieldException;

import java.util.Scanner;

public class Game {
    private GameField gameField;

    public Game(int size) {
        gameField = new GameField(size);
    }

    public void start() {
        while (!isFinished()) {
            boolean incorrectStep1 = true;

            while (incorrectStep1) {
                printField();

                try {
                    doStep(true);
                    incorrectStep1 = false;
                } catch (CellIsFilledException | CellIsOutOfFieldException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (isFinished()) {
                break;
            }

            boolean incorrectStep2 = true;

            while (incorrectStep2) {
                printField();

                try {
                    doStep(false);
                    incorrectStep2 = false;
                } catch (CellIsFilledException | CellIsOutOfFieldException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        printField();
    }

    private void printField() {
        for (int i = 0; i < gameField.getSize(); i++) {
            for (int j = 0; j < gameField.getSize(); j++) {
                System.out.print(PrintCellUtil.getCellLabel(gameField.getValue(i, j)));
            }
            System.out.println();
        }
    }

    private void doStep(Boolean value) throws CellIsFilledException, CellIsOutOfFieldException {
        System.out.println("Ход игрока " + PrintCellUtil.getCellLabel(value));

        int x = ConsoleReaderUtil.readNumber("Введите номер строки: ");
        int y = ConsoleReaderUtil.readNumber("Введите номер столбца: ");

        gameField.setValue(x, y, value);
    }

    private boolean isFinished() {
        GameChecker gameChecker = new GameChecker(gameField);

        boolean draw = gameField.allFieldIsFilled();
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
