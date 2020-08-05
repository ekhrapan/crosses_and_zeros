package academy.belhard.game;

public class GameChecker {

    private GameField gameField;

    public GameChecker(GameField gameField) {
        this.gameField = gameField;
    }

    public Boolean checkWinner() {
        Boolean checkRows = checkRows();
        if (checkRows != null) {
            return checkRows;
        }

        Boolean checkCols = checkCols();
        if (checkCols != null) {
            return checkCols;
        }

        Boolean mainDiagonal = checkMainDiagonal();
        if (mainDiagonal != null) {
            return mainDiagonal;
        }

        Boolean reverseDiagonal = checkReverseDiagonal();
        if (reverseDiagonal != null) {
            return reverseDiagonal;
        }

        return null;
    }

    private Boolean checkRows() {
        for (int i = 0; i < gameField.getSize(); i++) {
            Boolean firstCell = gameField.getValue(i, 0);

            if (firstCell == null) {
                continue;
            }

            for (int j = 1; j < gameField.getSize(); j++) {
                Boolean checkedCell = gameField.getValue(i, j);

                if (!firstCell.equals(checkedCell)) {
                    break;
                }

                if (j == gameField.getSize() - 1) {
                    return firstCell;
                }
            }
        }

        return null;
    }

    private Boolean checkCols() {
        for (int i = 0; i < gameField.getSize(); i++) {
            Boolean firstCell = gameField.getValue(0, i);

            if (firstCell == null) {
                continue;
            }

            for (int j = 1; j < gameField.getSize(); j++) {
                Boolean checkedCell = gameField.getValue(j, i);

                if (!firstCell.equals(checkedCell)) {
                    break;
                }

                if (j == gameField.getSize() - 1) {
                    return firstCell;
                }
            }
        }

        return null;
    }

    private Boolean checkMainDiagonal() {
        Boolean firstCell = gameField.getValue(0, 0);

        if (firstCell == null) {
            return null;
        }

        for (int i = 1; i < gameField.getSize(); i++) {
            if (!firstCell.equals(gameField.getValue(i, i))) {
                return null;
            }
        }

        return firstCell;
    }

    private Boolean checkReverseDiagonal() {
        int colNumber = 0;
        Boolean firstCell = gameField.getValue(gameField.getSize() - 1, colNumber);

        if (firstCell == null) {
            return null;
        }

        for (int i = gameField.getSize() - 2; i >= 0; i--) {
            colNumber++;
            if (!firstCell.equals(gameField.getValue(i, colNumber))) {
                return null;
            }
        }

        return firstCell;
    }

    public boolean allFieldIsFilled() {
        for (int i = 0; i < gameField.getSize(); i++) {
            for (int j = 0; j < gameField.getSize(); j++) {
                if (gameField.getValue(i, j) == null) {
                    return false;
                }
            }
        }

        return true;
    }
}
