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
    public void returnAnEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals("", calculator.calculator("1"));
    }

    @Test
    public void returnSameNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals("1", calculator.calculator("1"));
    }

    @Test
    public void returnAddTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals("3", calculator.calculator("1,2"));
    }

}
