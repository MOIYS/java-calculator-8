package calculator;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        StringCalculator stringCalculator = new StringCalculator();

        String userInput = input.requestInput();
        System.out.println("사용자가 입력한 문자열: " + userInput);

        int result = stringCalculator.calculate(userInput);

        System.out.println("결과: " + result);
    }
}
