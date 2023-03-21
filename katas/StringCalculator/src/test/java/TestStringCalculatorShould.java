import org.junit.Test;
import static org.junit.Assert.*;


public class TestStringCalculatorShould {
    /*
    * Make sure you only test for correct inputs. there is no need to test for invalid inputs for this kata.
    - Use cases:
        * 1. Given: empty string ("") When StringCalculator.add() Then return int 0.
        * 2. Given: string with one number ("1") When StringCalculator.add() Then return same number int 1.
        * 3. Given: string with two numbers ("1,2") When StringCalculator.add() Then return add(1,2) = int 3.
        * 4. Given: string with many numbers ("1,2,3") When StringCalculator.add() Then return add(1,2,3) = int 6.
        * 5. Given: string with new delimiter \n When StringCalculator.add() Then return add(1,2\n3) = int 6.
        * 6. Given: string with optional delimiter When StringCalculator.add() Then return add(\\;\n1;2;3) = int 6.
        * 7. Given: string with negative numbers When StringCalculator.add() Then return add("-1,-2") = NegativeNumbers: Negative numbers not allowed: [-1, -2]
        * 8. Given: string with numbers greater than 1000 When StringCalculator.add() Then return add avoiding numbers greater than 1000: add("1000,2") = 2.
        * 9. Given: When Then return
        * 10. Given: When Then return
        * 11. Given: When Then return
    */

    @Test
    public void returnAnEmptyString() throws NegativeNumbers {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void returnSameNumber() throws NegativeNumbers {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void returnAddTwoNumbers() throws NegativeNumbers {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void returnAddUnknowNumbers() throws NegativeNumbers {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }
    @Test
    public void returnAddWithNewDelimiter() throws NegativeNumbers {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }
    @Test
    public void returnAddWithAnothersDelimiters() throws NegativeNumbers {
        assertEquals(6, StringCalculator.add("//;\n1;2;3"));
    }
    @Test
    public void returnAddWithNegativeNumbers() throws NegativeNumbers {
        String errorResponse = "Negative numbers not allowed: [-1, -2]";

        NegativeNumbers thrown = assertThrows(NegativeNumbers.class, () ->
                StringCalculator.add("//;\n-1;-2;3"));
        assertEquals(thrown.getMessage(), errorResponse);
    }
    @Test
    public void returnAddWithNotNumbersGreaterThan1000() throws NegativeNumbers {
        assertEquals(2, StringCalculator.add("//'\n2'3000"));
    }
    @Test
    public void returnAddWithLongDelimiters() throws NegativeNumbers {
        assertEquals(2, StringCalculator.add("//[***]\n2***3000"));
    }
}
