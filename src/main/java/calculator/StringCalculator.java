package calculator;

public class StringCalculator {

    public int calculate(String text) {

        // 쉼표(,)를 기준으로 문자열을 분리하여, 숫자를 저장하는 문자열 배열을 만듦
        String[] numbers = text.split(",");

        int sum = 0;

        for(String number : numbers)
        {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
