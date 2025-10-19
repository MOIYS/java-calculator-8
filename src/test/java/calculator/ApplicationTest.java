package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 빈_문자열_입력_시_0_반환() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "";

        int result = stringCalculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void null_입력_시_0_반환() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = null;

        int result = stringCalculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 단일_숫자_입력_시_해당_숫자_반환() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "3";

        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자_없이_공백이_포함된_경우() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1, 2: 3 ";

        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자가_공백일_경우() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "// \\n1 2, 3 ";

        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 구분자가_연속으로_입력될_경우() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "//;\\n1,:;2,3";

        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
