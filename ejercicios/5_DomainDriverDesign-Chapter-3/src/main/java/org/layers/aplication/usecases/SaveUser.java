package org.layers.aplication.usecases;

import io.vavr.control.Either;
import org.layers.aplication.warnings.SaveUserWarning;
import org.layers.domain.interfaces.UserRepository;
import org.layers.domain.models.User;

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
