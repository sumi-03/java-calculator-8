package calculator.util;

public class InputValidator {

    public static String validateEmpty(String input) {

        if (input == null) {

            throw new IllegalArgumentException("입력값이 null입니다.");
        }

        input = input.trim();

        return input;
    }
}
