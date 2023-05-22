package org.domain.models;

import io.vavr.control.Either;
import org.domain.warnings.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    /**
     * Use cases:
     * 1. Create a User with all the fields correct.
     * 2. Create a User with many fields incorrect.
     */
    @Test
    public void createUser() {
        Either<UserWarnings, User> userCreated = User.createUser("prueba", "prueba@gmail.com", 20, "password");
        User user = userCreated.get();

        assertEquals(user.getUsername(), "prueba");
        assertEquals(user.getEmail(), "prueba@gmail.com");
        assertEquals(user.getAge(), 20);
        assertEquals(user.getPassword(), "password");
    }
    @Test
    public void returnManyWarningsWhenCreateUser() {
        Either<UserWarnings, User> userCreated = User.createUser("", "prueba.com", 12, "");
        UserWarnings userWarnings = userCreated.getLeft();

        assertEquals(userWarnings.getNameWarning(), NameWarning.NAME_CANNOT_BE_EMPTY);
        assertEquals(userWarnings.getEmailWarning(), EmailWarning.INCORRECT_EMAIL_FORMAT);
        assertEquals(userWarnings.getAgeWarning(), AgeWarning.AGE_UNDER_LIMIT);
        assertEquals(userWarnings.getPasswordWarning(), PasswordWarning.EMPTY_PASSWORD);
    }
}
