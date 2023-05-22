package org.layers.domain.value_objects;

import io.vavr.control.Either;
import org.layers.domain.warnings.NameWarning;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class NameTest {
    /** Use cases:
     * 1. Name should be created.
     * 2. Empty name -> return NameWarning.NAME_CANNOT_BE_EMPTY
     */
    String normal_name;
    String emptyName;
    @BeforeEach
    void setUp() {
        normal_name = "Nico";
        emptyName = "";
    }
    @Test
    public void nameShouldBeCreated() {
        Either<NameWarning,Name> nameCreated = Name.createName(normal_name);
        Name name = nameCreated.get();

        assertEquals(name.getName(), normal_name);
    }
    @Test
    public void emptyNameShouldNotBeCreated() {
        Either<NameWarning ,Name> nameCreated = Name.createName(emptyName);

        assertEquals(nameCreated.getLeft(), NameWarning.NAME_CANNOT_BE_EMPTY);
    }
}
