package org.aplication.usecases;

import io.vavr.control.Either;
import org.aplication.warnings.SaveUserWarning;
import org.domain.interfaces.UserRepository;
import org.domain.models.User;

public class SaveUser {
    private final UserRepository userRepository;
    public SaveUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Either<SaveUserWarning, User> saveUser(User user) {
        if (this.userRepository.userExists(user)) {
            return Either.left(SaveUserWarning.USER_ALREADY_EXISTS);
        }
        this.userRepository.saveUser(user);
        return Either.right(user);
    }
}
