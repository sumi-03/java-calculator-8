package calculator.domain;

import calculator.util.InputValidator;

public class StringCalculator {

    private final InputValidator inputValidator = new InputValidator();

    public int calculate(final String input) {

        String trimmedInput = inputValidator.validateEmpty(input);

        return 1; // 임시 반환
    }
}
