package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final StringCalculator stringCalculator = new StringCalculator();

    public void run() {

        String input = InputView.getUserInput();
        int result = stringCalculator.calculate(input);
        OutputView.printResult(result);
    }
}
