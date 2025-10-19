package calculator.util;

public final class CalculatorConstants {

    // 인스턴스화 방지 (유틸 전용 클래스)
    private CalculatorConstants() {
    }

    // 기본 구분자 (쉼표, 콜론)
    public static final String DEFAULT_DELIMITERS = ",|:";

    // 커스텀 구분자 정규식 패턴 (예: //;\n1;2;3)
    public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";
}