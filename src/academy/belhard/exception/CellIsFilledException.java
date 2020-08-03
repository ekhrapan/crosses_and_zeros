package academy.belhard.exception;

public class CellIsFilledException extends Exception {
    public static final String ERROR_MESSAGE = "Это поле уже занято";

    public CellIsFilledException() {
        super(ERROR_MESSAGE);
    }
}
