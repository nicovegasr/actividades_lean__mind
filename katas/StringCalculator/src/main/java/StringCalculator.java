import java.util.Arrays;

public class StringCalculator {

    public static int calculator(String numbers) {
        if (numbers.isEmpty()) return 0;
        String delimiter = "[,\n]";
        String numbersToCalculate = numbers;
        if (numbers.charAt(0) == '/') {
            delimiter = Character.toString(numbers.charAt(2));
            numbersToCalculate = numbers.substring(4);
        }
        String[] listNumbers = numbersToCalculate.split(delimiter);
        int add = Arrays.stream(listNumbers)
                .map(Integer::parseInt)
                .reduce(0, (accumulator, element) -> accumulator + element);
        return add;
    }
}

 // “//[delimiter]\n[numbers…]”
