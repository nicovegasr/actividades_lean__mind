package org.layers.domain.value_objects;

import io.vavr.control.Either;
import org.layers.domain.warnings.AgeWarning;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AgeTest {
    /**
     * Use cases:
     * 1. Age is created.
     * 2. Age under 13 -> "Error: AGE_UNDER_LIMIT"
     */
    Integer goodAge;
    Integer ageUnderLimit;
    @BeforeEach
    public void setUp() {
        goodAge = 20;
        ageUnderLimit = 12;
    }
    @Test
    public void shouldCreateAge() {
        Either<AgeWarning, Age> ageCreated = Age.createAge(goodAge);
        Age age = ageCreated.get();

        assertEquals(age.getAge(), 20);
    }

    @Test
    public void should_not_create_age_under_13() {
        Either<AgeWarning, Age> ageCreated = Age.createAge(ageUnderLimit);

        assertEquals(ageCreated.getLeft(), AgeWarning.AGE_UNDER_LIMIT);
    }
}
