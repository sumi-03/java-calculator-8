package calculator.util;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    @Test
    void 커스텀구분자_형식이_올바르면_Matcher를_반환한다() {
        // given
        String input = "//;\n1;2;3";

        // when
        Matcher matcher = InputValidator.validateCustomDelimiterFormat(input);

        // then
        assertNotNull(matcher);
        assertEquals(";", matcher.group(1)); // 구분자
        assertEquals("1;2;3", matcher.group(2)); // 본문
    }

    @Test
    void 커스텀구분자_형식이_잘못되면_예외를_발생시킨다() {
        // given
        String input = "//;\r1;2";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCustomDelimiterFormat(input));
    }

    @Test
    void 허용된_문자만_포함된_경우_통과한다() {
        // given
        String input = "//;\n1;2;3";
        String delimiter = ",|:|;";

        // when & then
        assertThatCode(() -> InputValidator.validateAllowedCharacters(input, delimiter))
                .doesNotThrowAnyException();
    }

    @Test
    void 허용되지_않은_문자가_포함된_경우_예외를_발생시킨다() {
        // given
        String input = "//;\n1;2;3a";
        String delimiter = ",|:|;";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateAllowedCharacters(input, delimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("허용되지 않은 문자");
    }
}
