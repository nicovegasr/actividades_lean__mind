import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class FizzBuzzTest {
    /* Casos de uso:
     * 
     * 1.- Con un 0  devuelve una lista vacia. expected: []
     * 2.- Si le pasas un 1 expected: 1, [1]
     * 3.- El 3 se transforma en FizzFizz
     * 4.- El 5 se transforma en BuzzBuzz
     * 5.- El 15 se transforma en FizzBuzzBuzz
     * Modificación: Si un numero tiene un 3 en el se devuelve Fizz y si tiene un 5 Buzz.
     */
    @Test
    public void testFizzBuzzMethodWithEmptyList() {
        List<String> result = FizzBuzz.fizzBuzzMethod(0);
        List<String> expected =  new ArrayList<>(0);
        assertEquals( expected, result);
    }

    @Test
    public void testFizzBuzzMethodWithOnePupil() {
        List<String> result = FizzBuzz.fizzBuzzMethod(1);
        List<String> expected =  new ArrayList<>(1);
        expected.add("1");
        assertEquals( expected, result);
    }
    @Test
    public void testFizzBuzzMethodWith3() {
        List<String> result = FizzBuzz.fizzBuzzMethod(20);
        String number3 = result.get(2);
        assertEquals( "FizzFizz", number3);
    }
    @Test
    public void testFizzBuzzMethodWith5() {
        List<String> result = FizzBuzz.fizzBuzzMethod(20);
        String number5 = result.get(4);
        assertEquals( "BuzzBuzz", number5);
    }
    @Test
    public void testFizzBuzzMethodWith15() {
        List<String> result = FizzBuzz.fizzBuzzMethod(20);
        String number15 = result.get(14);
        assertEquals( "FizzBuzzBuzz", number15);
    }
}
