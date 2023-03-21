import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int add(String numbers) throws NegativeNumbers  {
        if (numbers.isEmpty()) return 0;
        List<String> data = setDelimiterAndNumbers(numbers);
        String delimiter = data.get(0);
        String numbersToCalculate = data.get(1);
        List<String> numbersList = Arrays.asList(numbersToCalculate.split(delimiter));
        try {
            checkNegativeNumbers(numbersList);
        }
        catch (NegativeNumbers exception) {
            throw exception;
        }
        return addNumbers(numbersList);
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
    private static int addNumbers(List<String> listNumbers) {
        int add = 0;
        for (String number : listNumbers) {
            if (Integer.parseInt(number) > 1000) ;
            else add = add + Integer.parseInt(number);
        }
        return add;
    }

    private static void checkNegativeNumbers(List<String> listNumbers) throws NegativeNumbers {
        List<Integer> negativeNumbers = new ArrayList<>();
        Boolean thereAreNegativeNumbers = false;
        for(String number : listNumbers) {
            int integerNumber = Integer.parseInt(number);
            if (integerNumber < 0) {
                thereAreNegativeNumbers = true;
                negativeNumbers.add(integerNumber);
            }
        }
        if (thereAreNegativeNumbers) {
            throw new NegativeNumbers(negativeNumbers);
        }
    }
}