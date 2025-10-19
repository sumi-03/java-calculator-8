package calculator.util;

public final class Constants {

    // 인스턴스화 방지 (유틸 전용 클래스)
    private Constants() {
    }

    // Domain
    public static final String DEFAULT_DELIMITERS = ",|:"; // 기본 구분자 (쉼표, 콜론)
    public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\\\n(.*)"; // 커스텀 구분자 정규식 패턴 (예: //;\n1;2;3)

    // View
    public static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String RESULT_MESSAGE = "결과 : ";
}
