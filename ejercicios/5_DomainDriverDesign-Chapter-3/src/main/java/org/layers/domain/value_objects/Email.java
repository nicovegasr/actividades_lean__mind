package org.layers.domain.value_objects;

import io.vavr.control.Either;
import org.layers.domain.warnings.EmailWarning;

public class Email {
    String email;
    private Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public static Either<EmailWarning, Email> createEmail(String email) {
        boolean incorrectFormat = !(email.matches("^([\\w-.]+)@([\\w-]+\\.)+[\\w-]{2,4}$"));
        if (email.isEmpty()) {
            return Either.left(EmailWarning.EMAIL_IS_EMPTY);
        }
        if (incorrectFormat) {
            return Either.left(EmailWarning.INCORRECT_EMAIL_FORMAT);
        }
        return Either.right(new Email(email));
    }
}
