package org.domain.models;

import io.vavr.control.Either;
import org.domain.value_objects.Age;
import org.domain.value_objects.Email;
import org.domain.value_objects.Name;
import org.domain.warnings.AgeWarning;
import org.domain.warnings.EmailWarning;
import org.domain.warnings.NameWarning;
import org.domain.warnings.UserWarnings;

public class User {
    private final Name username;
    private final Email email;
    private final Age age;
    private User(Name username, Email email, Age age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
    public static Either<UserWarnings, User> createUser(String username, String email, int age) {
        Either<NameWarning, Name> nameCreated = Name.createName(username);
        Either<EmailWarning, Email> emailCreated = Email.createEmail(email);
        Either<AgeWarning, Age> ageCreated = Age.createAge(age);
        UserWarnings userWarning = User.validate(nameCreated, emailCreated, ageCreated);
        if (userWarning.warningExist()){
            return Either.left(userWarning);
        }
        return Either.right(new User(nameCreated.get(), emailCreated.get(), ageCreated.get()));
    }
    private static UserWarnings validate(Either<NameWarning, Name> nameCreated, Either<EmailWarning, Email> emailCreated, Either<AgeWarning, Age> ageCreated) {
        UserWarnings userWarning = new UserWarnings();
        if (nameCreated.isLeft()) {
            userWarning.setNameWarning(nameCreated.getLeft());
        }
        if (emailCreated.isLeft()) {
            userWarning.setEmailWarning(emailCreated.getLeft());
        }
        if (ageCreated.isLeft()) {
            userWarning.setAgeWarning(ageCreated.getLeft());
        }
        return userWarning;
    }
    public String getUsername() {
        return username.getName();
    }

    public String getEmail() {
        return email.getEmail();
    }

    public Integer getAge() {
        return age.getAge();
    }
}
