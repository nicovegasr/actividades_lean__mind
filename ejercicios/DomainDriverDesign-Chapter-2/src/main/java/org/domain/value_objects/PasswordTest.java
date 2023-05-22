package org.domain.value_objects;

import io.vavr.control.Either;
import org.domain.warnings.PasswordWarning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {
    /**
    *  Use cases:
     *  1. Password created
     *  2. Empty password -> PasswordWarning.PASSWORD_CANNOT_BE_EMPTY
     *  3. Password size - 8 -> PasswordWarning.PASSWORD_SIZE_UNDER_8
    */
    @Test
    public void passwordCreated() {
        Either<PasswordWarning, Password> passwordCreated = Password.createPassword("password");
        Password password = passwordCreated.get();

        assertEquals(password.getPassword(), "password");
    }
    @Test
    public void emptyPasswordShouldReturnPasswordWarning() {
        Either<PasswordWarning, Password> passwordCreated = Password.createPassword("");
        PasswordWarning passwordWarning = passwordCreated.getLeft();

        assertEquals(passwordWarning, PasswordWarning.EMPTY_PASSWORD);
    }
    @Test
    public void passwordSizeUnder8ShouldReturnPasswordWarning() {
        Either<PasswordWarning, Password> passwordCreated = Password.createPassword("pass");
        PasswordWarning passwordWarning = passwordCreated.getLeft();

        assertEquals(passwordWarning, PasswordWarning.PASSWORD_SIZE_UNDER_8);
    }
}
