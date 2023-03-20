import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        List<String> data = setDelimiterAndNumbers(numbers);
        String delimiter = data.get(0);
        String numbersToCalculate = data.get(1);
        return addNumbers(numbersToCalculate, delimiter);
    }

    private static List<String> setDelimiterAndNumbers(String numbers) {
        String delimiter = "[,\n]";
        String numbersToCalculate = numbers;
        if (numbers.charAt(0) == '/') {
            delimiter = Character.toString(numbers.charAt(2));
            numbersToCalculate = numbers.substring(4);
        }
        List<String> result = new ArrayList<>(2);
        result.add(delimiter);
        result.add(numbersToCalculate);
        return result;
    }
    private static int addNumbers(String numbersToCalculate, String delimiter) {
        String[] listNumbers = numbersToCalculate.split(delimiter);
        int add = Arrays.stream(listNumbers)
                .map(Integer::parseInt)
                .reduce(0, (accumulator, element) -> accumulator + element);
        return add;
    }
}