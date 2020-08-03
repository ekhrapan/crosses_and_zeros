package academy.belhard.game;

import academy.belhard.exception.CellIsFilledException;
import academy.belhard.exception.CellIsOutOfFieldException;

public class GameField {
    private Boolean[][] field;

    public GameField(int size) {
        field = new Boolean[size][size];
    }

    public void setValue(int x, int y, boolean value) throws CellIsFilledException, CellIsOutOfFieldException {
        if (x >= field.length || y >= field.length) {
            throw new CellIsOutOfFieldException();
        }

        if (field[x][y] == null) {
            field[x][y] = value;
        } else {
            throw new CellIsFilledException();
        }
    }

    public Boolean getValue(int x, int y) {
        return field[x][y];
    }

    public int getSize() {
        return field.length;
    }

    public boolean allFieldIsFilled() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == null) {
                    return false;
                }
            }
        }

        return true;
    }
}
