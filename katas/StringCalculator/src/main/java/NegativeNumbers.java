import java.util.List;

public class NegativeNumbers extends Exception {
    public NegativeNumbers(List<Integer> numbers) {
        super("Negative numbers not allowed: " + numbers);
    }
}
