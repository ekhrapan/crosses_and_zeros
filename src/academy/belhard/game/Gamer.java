package academy.belhard.game;

import academy.belhard.exception.CellIsFilledException;
import academy.belhard.exception.CellIsOutOfFieldException;
import academy.belhard.util.ConsoleReaderUtil;
import academy.belhard.util.PrintCellUtil;

public class Gamer {
    private GameField gameField;
    private boolean type;

    public Gamer(GameField gameField, boolean type) {
        this.gameField = gameField;
        this.type = type;
    }

    public void doAction() throws CellIsFilledException, CellIsOutOfFieldException {
        System.out.println("Ход игрока " + PrintCellUtil.getCellLabel(type));

        int x = ConsoleReaderUtil.readNumber("Введите номер строки: ") - 1;
        int y = ConsoleReaderUtil.readNumber("Введите номер столбца: ") - 1;

        gameField.setValue(x, y, type);
    }
}
