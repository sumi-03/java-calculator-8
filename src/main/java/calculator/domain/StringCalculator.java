package calculator.domain;

import calculator.util.InputValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:"; // 기본 구분자
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)"; // //;\n1;2;3 형식 검증용 정규식
    private final InputValidator inputValidator = new InputValidator();

    public int calculate(String input) {

        input = inputValidator.validateEmpty(input);

        if (input.isEmpty()) {

            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        String numbers;
        String delimiter = DEFAULT_DELIMITERS;

        if (matcher.matches()) {

            String customDelimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자
            delimiter = DEFAULT_DELIMITERS + "|" + customDelimiter; // 기본 + 커스텀 결합
            numbers = matcher.group(2); // 계산할 문자열
        } else {
            numbers = input;
        }

        return 1; // 임시 반환
    }
}
