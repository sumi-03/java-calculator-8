package calculator.controller;

import calculator.view.InputView;

public class CalculatorController {

    private final InputView inputView = new InputView();

    public void run() {

        String input = inputView.getUserInput();
    }
}
