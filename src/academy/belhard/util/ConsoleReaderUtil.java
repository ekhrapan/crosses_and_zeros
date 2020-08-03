package academy.belhard.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReaderUtil {

    public static int readNumber(String message) {
        int number = 0;

        boolean incorrectInput = true;

        while (incorrectInput) {
            try {
                System.out.print(message);
                Scanner scanner = new Scanner(System.in);
                number = scanner.nextInt();
                incorrectInput = false;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод");
            }
        }

        return number;
    }
}
