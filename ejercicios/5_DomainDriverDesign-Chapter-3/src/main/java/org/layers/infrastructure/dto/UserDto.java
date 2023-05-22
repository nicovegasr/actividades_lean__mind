package org.layers.infrastructure.dto;

import io.vavr.control.Either;
import org.layers.domain.models.User;
import org.layers.domain.warnings.UserWarnings;

import java.util.Map;

public class UserDto {
    public static Either<UserWarnings, User> createUserFromRequest(Map request) {
        String username = (String) request.get("name");
        String email = (String) request.get("email");
        Integer userAge = (Integer) request.get("age");
        String password = (String) request.get("password");
        Either<UserWarnings, User> userCreated = User.createUser(username, email, userAge, password);
        if (userCreated.isLeft()) {
            return Either.left(userCreated.getLeft());
        }
        return Either.right(userCreated.get());
    }
}
