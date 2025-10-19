package calculator.domain;

import calculator.util.InputValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.Constants.DEFAULT_DELIMITERS;

public class StringCalculator {

    public int calculate(String input) {

        // 입력값 검증 (null, 공백 처리)
        input = InputValidator.validateEmpty(input);
        if (input.isEmpty()) return 0; // 빈 문자열이면 0 반환

        // 문자열 파싱 및 구분자 처리
        String[] tokens = parseNumbers(input);

        // 음수 검증
        InputValidator.validateNoNegative(tokens);

        // 합산 결과 반환
        return calculateSum(tokens);
    }

    // 문자열에서 구분자 파싱 및 숫자 추출
    private String[] parseNumbers(String input) {

        Matcher matcher = InputValidator.validateCustomDelimiterFormat(input);
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        if (matcher != null) {
            // 커스텀 구분자 존재 시 병합
            String customDelimiter = Pattern.quote(matcher.group(1));
            delimiter += "|" + customDelimiter;
            numbers = matcher.group(2); // 실제 계산 대상
        }

        // 허용되지 않은 문자 검증
        InputValidator.validateAllowedCharacters(numbers, delimiter);

        // 구분자를 기준으로 숫자 분리
        return numbers.split(delimiter);
    }

    // 숫자 배열의 합 계산
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
