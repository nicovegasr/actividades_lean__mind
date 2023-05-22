package org.layers.domain.models;

import io.vavr.control.Either;
import org.layers.domain.value_objects.Age;
import org.layers.domain.value_objects.Email;
import org.layers.domain.value_objects.Name;
import org.layers.domain.value_objects.Password;
import org.layers.domain.warnings.*;

public class User {
    private final Name username;
    private final Email email;
    private final Age age;
    private final Password password;
    private User(Name username, Email email, Age age, Password password) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.password = password;
    }
    public static Either<UserWarnings, User> createUser(String username, String email, int age, String password) {
        Either<NameWarning, Name> nameCreated = Name.createName(username);
        Either<EmailWarning, Email> emailCreated = Email.createEmail(email);
        Either<AgeWarning, Age> ageCreated = Age.createAge(age);
        Either<PasswordWarning, Password> passwordCreated = Password.createPassword(password);
        UserWarnings userWarning = User.validate(nameCreated, emailCreated, ageCreated, passwordCreated);
        if (userWarning.warningExist()){
            return Either.left(userWarning);
        }
        return Either.right(new User(nameCreated.get(), emailCreated.get(), ageCreated.get(), passwordCreated.get()));
    }
    private static UserWarnings validate(Either<NameWarning, Name> nameCreated, Either<EmailWarning, Email> emailCreated, Either<AgeWarning, Age> ageCreated, Either<PasswordWarning, Password> passwordCreated) {
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
        if(passwordCreated.isLeft()){
            userWarning.setPasswordWarning(passwordCreated.getLeft());
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

    public String getPassword() { return password.getPassword();}
}
