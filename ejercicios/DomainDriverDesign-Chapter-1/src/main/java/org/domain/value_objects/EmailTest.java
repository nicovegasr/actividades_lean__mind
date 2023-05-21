package org.domain.value_objects;
import io.vavr.control.Either;
import org.domain.warnings.EmailWarning;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    /**
     * Use cases:
     * 1. Email is created
     * 2. Empty Email -> return EmailWarning.EMAIL_IS_EMPTY
     * 3. Incorrect email format email -> return EmailWarning.INCORRECT_EMAIL_FORMAT
     *
     * Técnicamente un email vacío no cumple con el formato por lo que quizás podríamos quitar el caso de uso 2 pero
     * prefiero diferenciar los casos.
     */
    String goodEmail;
    String emptyEmail;
    String badFormatEmail;
    @BeforeEach
    void setUp() {
        goodEmail = "prueba@gmail.com";
        emptyEmail = "";
        badFormatEmail = "prueba.com";
    }
    @Test
    public void shouldCreateEmail() {
        Either<EmailWarning, Email> emailCreated = Email.createEmail(goodEmail);
        Email email = emailCreated.get();

        assertEquals(email.getEmail(), goodEmail);
    }
    @Test
    public void shouldNotCreateEmailBecauseIsEmpty() {
        Either<EmailWarning, Email> emailCreated = Email.createEmail(emptyEmail);

        assertEquals(emailCreated.getLeft(), EmailWarning.EMAIL_IS_EMPTY);
    }
    @Test
    public void shouldNotCreateEmailBecauseEmailFormatIsIncorrect() {
        Either<EmailWarning, Email> emailCreated = Email.createEmail(badFormatEmail);

        assertEquals(emailCreated.getLeft(), EmailWarning.INCORRECT_EMAIL_FORMAT);
    }
}
