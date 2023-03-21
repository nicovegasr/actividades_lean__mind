import org.junit.Test;
import static org.junit.Assert.*;


public class TestStringCalculatorShould {
    /*
    * Make sure you only test for correct inputs. there is no need to test for invalid inputs for this kata.
    - Use cases:
        * 1. Given: empty string ("") When StringCalculator.calculator() Then return string 0.
        * 2. Given: string with one number ("1") When StringCalculator.calculator() Then return same number string 1.
        * 3. Given: string with two numbers ("1,2") When StringCalculator.calculator() Then return add(1,2) = string 3.
        * 4.
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
    public void returnAddWithNewRegex() throws NegativeNumbers {
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
}
