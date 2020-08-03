package academy.belhard.exception;

public class CellIsOutOfFieldException extends Exception {
    public static final String ERROR_MESSAGE = "Выход за пределы поля";

    public CellIsOutOfFieldException() {
        super(ERROR_MESSAGE);
    }
}
