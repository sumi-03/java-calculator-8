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

    public static void validateAllowedCharacters(String input, String delimiter) {

        // 커스텀 구분자 선언부 제외
        if (input.startsWith("//")) {

            int index = input.indexOf("\n");

            if (index != -1) {

                input = input.substring(index + 1);
            }
        }

        String[] delimiters = delimiter.split("\\|");
        StringBuilder patternBuilder = new StringBuilder("^[0-9");

        for (String d : delimiters) {

            for (char c : d.toCharArray()) {

                if ("\\^$.|?*+()[]{}".indexOf(c) >= 0) {
                    patternBuilder.append("\\").append(c);
                } else {
                    patternBuilder.append(c);
                }
            }
        }

        patternBuilder.append("\\n]+$");
        String allowedPattern = patternBuilder.toString();

        if (!input.matches(allowedPattern)) {

            throw new IllegalArgumentException("입력값에 허용되지 않은 문자가 포함되어 있습니다.");
        }
    }
}
