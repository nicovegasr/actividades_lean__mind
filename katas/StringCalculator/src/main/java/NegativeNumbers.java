import java.util.List;

public class NegativeNumbers extends RuntimeException {
    public NegativeNumbers(List<Integer> numbers) {
        super("Negative numbers not allowed: " + numbers);
    }
}
