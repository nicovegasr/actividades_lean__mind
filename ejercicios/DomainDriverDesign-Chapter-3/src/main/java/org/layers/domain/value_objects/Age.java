package org.layers.domain.value_objects;

import io.vavr.control.Either;
import org.layers.domain.warnings.AgeWarning;

public class Age {
    private final Integer age;
    private Age(Integer age) {
        this.age = age;
    }
    public static Either<AgeWarning, Age> createAge(Integer age) {
        if (age <= 13) {
            return Either.left(AgeWarning.AGE_UNDER_LIMIT);
        }
        return Either.right(new Age(age));
    }
    public Integer getAge() {
        return age;
    }
}
