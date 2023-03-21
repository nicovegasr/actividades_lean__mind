import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String numbers) throws NegativeNumbers  {
        if (numbers.isEmpty()) return 0;
        List<String> data = setDelimiterAndNumbers(numbers);
        String delimiter = data.get(0);
        String numbersToCalculate = data.get(1);
        List<String> numbersList = Arrays.asList(numbersToCalculate.split(delimiter));
        checkNegativeNumbers(numbersList);
        return addNumbers(numbersList);
    }

    private static List<String> setDelimiterAndNumbers(String numbers) {
        String delimiter = "[,\n]";
        String numbersToCalculate = numbers;
        if (thereAreDelimiterIn(numbers)) {
            if (thereAreLongDelimiterIn(numbers)) {
                delimiter = longDelimiter(numbers);
            } else {
                delimiter = Character.toString(numbers.charAt(2));
            }
            numbersToCalculate = numbers.substring(numbers.indexOf('\n')+1);
        }
        List<String> result = new ArrayList<>(2);
        result.add(delimiter);
        result.add(numbersToCalculate);
        return result;
    }

    private static Boolean thereAreLongDelimiterIn(String numbers) {
        if (numbers.charAt(2) == '[') {
            return true;
        } else {
            return false;
        }
    }
    public static String longDelimiter(String numbers) {
        String delimiter = numbers.substring(3, 6);
        String escapedDelimiterToSpecialCharacter = Pattern.quote(delimiter);
        return escapedDelimiterToSpecialCharacter;
    }
    private static Boolean thereAreDelimiterIn(String numbers) {
        if (numbers.charAt(0) == '/') {
            return true;
        } else {
            return false;
        }
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