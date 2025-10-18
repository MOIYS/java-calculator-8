package calculator;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        StringCalculator stringCalculator = new StringCalculator();
        Output output = new Output();

        String userInput = input.requestInput();
        output.printInputConfirmation(userInput);

        int result = stringCalculator.calculate(userInput);

        output.printResult(result);
    }
}
