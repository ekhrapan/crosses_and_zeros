package academy.belhard.util;

public class PrintCellUtil {
    public static String getCellLabel(Boolean cellValue) {

        if (Boolean.TRUE.equals(cellValue)) {
            return "X";
        }

        if (Boolean.FALSE.equals(cellValue)) {
            return "0";
        }

        return "-";
    }
}
