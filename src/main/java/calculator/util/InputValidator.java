package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.CalculatorConstants.CUSTOM_DELIMITER_PATTERN;

public class InputValidator {

    public static String validateEmpty(String input) {

        if (input == null) {

            throw new IllegalArgumentException("입력값이 null입니다.");
        }

        input = input.trim();

        if (input.isEmpty()) {

            return "";
        }

        return input;
    }

    public static Matcher validateCustomDelimiterFormat(String input) {

        if (!input.startsWith("//")) {

            return null; // 커스텀 구분자 아님
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        if (!matcher.matches()) {

            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다. (예: //;\\n1;2;3)");
        }

        return matcher; // 검증 통과된 matcher 반환
    }
}
