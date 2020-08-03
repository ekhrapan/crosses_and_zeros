package academy.belhard.game;

public class GameChecker {

    private GameField gameField;

    public GameChecker(GameField gameField) {
        this.gameField = gameField;
    }

    public Boolean checkWinner() {
        for (int i = 0; i < gameField.getSize(); i++) {
            if (gameField.getValue(i, 0) != null && gameField.getValue(i, 0).equals(gameField.getValue(i, 1)) && gameField.getValue(i, 0).equals(gameField.getValue(i, 2))) {
                return gameField.getValue(i, 0);
            }
        }

        for (int i = 0; i < gameField.getSize(); i++) {
            if (gameField.getValue(0, i) != null && gameField.getValue(0, i).equals(gameField.getValue(1, i)) && gameField.getValue(0, i).equals(gameField.getValue(2, i))) {
                return gameField.getValue(0, i);
            }
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

    //     0123
    //     ----
    // 0 | X0X0
    // 1 | X0X0
    // 2 | X0X0
    // 3 | X0X0


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
}
