package calculator.domain;

import calculator.util.InputValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.Constants.DEFAULT_DELIMITERS;

public class StringCalculator {

    public int calculate(String input) {

        input = InputValidator.validateEmpty(input);

        if (input.isEmpty()) {

            return 0;
        }

        Matcher matcher = InputValidator.validateCustomDelimiterFormat(input);

        String numbers;
        String delimiter = DEFAULT_DELIMITERS;

        if (matcher != null) { // 커스텀 구분자 존재

            String customDelimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자
            delimiter = DEFAULT_DELIMITERS + "|" + customDelimiter; // 기본 + 커스텀 결합
            numbers = matcher.group(2); // 계산할 문자열
        } else {
            numbers = input;
        }

        InputValidator.validateAllowedCharacters(numbers, delimiter);

        String[] tokens = numbers.split(delimiter);

        int sum = 0;

        for (String token : tokens) {

            if (!token.isEmpty()) {

                int number = Integer.parseInt(token);

                if (number < 0) {

                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }

                sum += number;
            }
        }

        return sum;
    }
}
