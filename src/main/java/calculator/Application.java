package calculator;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();

        String userInput = input.requestInput();
        System.out.println("사용자가 입력한 문자열: " + userInput);
    }
}
