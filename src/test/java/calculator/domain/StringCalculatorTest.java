package calculator.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void 빈_문자열_입력시_0을_반환한다(){
        // given
        String input = "";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(0);
    }
}
