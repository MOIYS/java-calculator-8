package calculator;

import java.util.regex.Pattern;  // Pattern.quote

public class StringCalculator {

    // 기본 구분자로 쉼표(,)와 콜론(:) 사용
    private static final String DEFAULT_DELIMITERS_REGEX = "[,:]";

    public int calculate(String text) {

        if(text == null || text.isEmpty()) {
            return 0;
        }

        String finalRegex = DEFAULT_DELIMITERS_REGEX;

        // 입력이 "//"로 시작하면, 커스텀 구분자 형식으로 간주
        if(text.startsWith("//")) {
            String[] parts = text.split(Pattern.quote("\\n"), 2);
            String header = parts[0];
            String body = parts[1];

            text = body;
            String customDelimiter = header.substring(2);

            if(!customDelimiter.isEmpty()) {
                finalRegex = Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITERS_REGEX;
            }
        }

        String[] numbers = text.split(finalRegex);

        int sum = 0;
        for(String numberStr : numbers)
        {
            // 숫자로 변환하기 전, 앞뒤 공백 제거
            String trimmedNumberStr = numberStr.trim();

            // 공백 제거 후, 빈 문자열이 아닌지 확인
            if(!trimmedNumberStr.isEmpty()) {
                try {
                    int number = Integer.parseInt(trimmedNumberStr);

                    // 음수면, 예외 발생
                    if(number < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                    }

                    sum += number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 문자는 입력할 수 없습니다.");
                }
            }
        }

        return sum;
    }
}
