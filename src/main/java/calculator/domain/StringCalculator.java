package calculator.domain;

import calculator.util.InputValidator;

public class StringCalculator {

    private final InputValidator inputValidator = new InputValidator();

    public int calculate(String input) {

        input = inputValidator.validateEmpty(input);

        if (input.isEmpty()) {

            return 0;
        }

        return 1; // 임시 반환
    }
}
