package academy.belhard.util;

import academy.belhard.game.GameField;

public class GameFieldPrintUtil {

    public static void printField(GameField gameField) {
        for (int i = 0; i < gameField.getSize(); i++) {
            for (int j = 0; j < gameField.getSize(); j++) {
                System.out.print(PrintCellUtil.getCellLabel(gameField.getValue(i, j)));
            }
            System.out.println();
        }
    }
}
