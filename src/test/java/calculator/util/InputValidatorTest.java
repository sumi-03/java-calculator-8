package calculator.util;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    @Test
    void 커스텀구분자_형식이_올바르면_Matcher를_반환한다() {

        Matcher matcher = InputValidator.validateCustomDelimiterFormat("//;\n1;2;3");
        assertNotNull(matcher);
        assertEquals(";", matcher.group(1)); // 구분자
        assertEquals("1;2;3", matcher.group(2)); // 본문
    }

    @Test
    void 커스텀구분자_형식이_잘못되면_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCustomDelimiterFormat("//;\r1;2"));
    }
}
