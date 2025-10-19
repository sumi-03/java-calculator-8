package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.Constants.CUSTOM_DELIMITER_PATTERN;

public class InputValidator {

    // 입력값의 null 및 공백 검증
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

    // 커스텀 구분자 형식 검증
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

    // 허용된 문자(숫자, 구분자, 개행)만 포함되어 있는지 검증
    public static void validateAllowedCharacters(String input, String delimiter) {

        String sanitizedInput = removeCustomDelimiterDeclaration(input);
        String allowedPattern = buildAllowedPattern(delimiter);

        if (!sanitizedInput.matches(allowedPattern)) {

            throw new IllegalArgumentException("입력값에 허용되지 않은 문자가 포함되어 있습니다.");
        }
    }

    // 커스텀 구분자 선언부 제거 (예: //;\n 이후 숫자만 남김)
    private static String removeCustomDelimiterDeclaration(String input) {

        if (input.startsWith("//")) {

            int index = input.indexOf("\n");

            if (index != -1) {

                return input.substring(index + 1);
            }
        }

        return input;
    }

    // 허용 문자 정규식 패턴 생성
    private static String buildAllowedPattern(String delimiter) {

        String[] delimiters = delimiter.split("\\|");
        StringBuilder builder = new StringBuilder("^[0-9");

        for (String d : delimiters) {

            for (char c : d.toCharArray()) {
                // 정규식 특수문자는 이스케이프 처리
                if ("\\^$.|?*+()[]{}".indexOf(c) >= 0) {
                    builder.append("\\").append(c);
                } else {
                    builder.append(c);
                }
            }
        }

        builder.append("\\n]+$");
        return builder.toString();
    }

    // 음수 값이 존재하는지 검증
    public static void validateNoNegative(String[] tokens) {

        for (String token : tokens) {

            if (!token.isEmpty()) {

                int number = Integer.parseInt(token);

                if (number < 0) {

                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
            }
        }
    }
}
