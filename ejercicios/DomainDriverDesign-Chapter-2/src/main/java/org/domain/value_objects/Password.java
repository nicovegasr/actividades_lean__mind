package org.domain.value_objects;

import io.vavr.control.Either;
import org.domain.warnings.PasswordWarning;

public class Password {
    private final String password;
    private Password(String password) {
        this.password = password;
    }
    public static Either<PasswordWarning, Password> createPassword(String password) {
        if (password.isEmpty()) {
            return Either.left(PasswordWarning.EMPTY_PASSWORD);
        }
        if (password.length() < 8) {
            return Either.left(PasswordWarning.PASSWORD_SIZE_UNDER_8);
        }
        return Either.right(new Password(password));
    }
    public String getPassword() {
        return password;
    }
}
