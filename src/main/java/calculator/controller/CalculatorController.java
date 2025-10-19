package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;

public class CalculatorController {

    private final StringCalculator stringCalculator = new StringCalculator();

    public void run() {

        String input = InputView.getUserInput();
        int result = stringCalculator.calculate(input);
    }
}
