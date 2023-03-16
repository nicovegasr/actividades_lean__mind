public class StringCalculator {

    public static String calculator(String numbers) {
        int firstNumber = Character.getNumericValue(numbers.charAt(0));
        int secondNumber = Character.getNumericValue(numbers.charAt(2));
        int add = firstNumber + secondNumber;
        return Integer.toString(add);
    }
}
