
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class FizzBuzz {
    public static @NotNull List<String> fizzBuzzMethod(int pupils) {
        List<String> result = new ArrayList<>(pupils);
        for (int pupil = 1; pupil <= pupils; pupil++) {
            String pupilResult = buildingResult(pupil);
            result.add(pupilResult);
        }
        return result;
    }

    private static String buildingResult(int pupil) {
        String result = "";
        result = result.concat(checkFizz(pupil));
        result = result.concat(checkBuzz(pupil));
        if (result.isEmpty()) result = Integer.toString(pupil);
        return result;
    }

    private static String checkFizz(int pupil) {
        String result = "";
        String pupilString = Integer.toString(pupil);
        if (pupil % 3 == 0) result = result.concat("Fizz");
        if (pupilString.contains("3")) result = result.concat("Fizz");
        return result;
    }

    private static String checkBuzz(int pupil) {
        String result = "";
        String pupilString = Integer.toString(pupil);
        if (pupil % 5 == 0) result = result.concat("Buzz");
        if (pupilString.contains("5")) result = result.concat("Buzz");
        return result;
    }
}
