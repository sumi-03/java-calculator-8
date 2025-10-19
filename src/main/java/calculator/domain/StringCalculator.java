package calculator.domain;

import calculator.util.InputValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.Constants.DEFAULT_DELIMITERS;

public class StringCalculator {

    public int calculate(String input) {

        input = InputValidator.validateEmpty(input);

        if (input.isEmpty()) return 0;

        String[] tokens = parseNumbers(input);

        InputValidator.validateNoNegative(tokens);

        return calculateSum(tokens);
    }

    private String[] parseNumbers(String input) {

        Matcher matcher = InputValidator.validateCustomDelimiterFormat(input);
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        if (matcher != null) {

            String customDelimiter = Pattern.quote(matcher.group(1));
            delimiter += "|" + customDelimiter;
            numbers = matcher.group(2);
        }

        InputValidator.validateAllowedCharacters(numbers, delimiter);

        return numbers.split(delimiter);
    }

    private int calculateSum(String[] tokens) {

        int sum = 0;

        for (String token : tokens) {

            if (!token.isEmpty()) {

                sum += Integer.parseInt(token);
            }
        }

        return sum;
    }
}
