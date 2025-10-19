package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import static calculator.util.Constants.START_MESSAGE;

public class InputView {

    public static String getUserInput() {

        System.out.println(START_MESSAGE);
        return Console.readLine();
    }
}
