package org.layers.infrastructure.api.controllers;

import io.vavr.control.Either;
import org.layers.aplication.usecases.SaveUser;
import org.layers.aplication.warnings.SaveUserWarning;
import org.layers.domain.models.User;
import org.layers.domain.warnings.UserWarnings;
import org.layers.infrastructure.database.repositories.UserRepositoryAlwaysSaveMockAdapter;
import org.layers.infrastructure.dto.UserDto;
import org.layers.infrastructure.resumedViews.UserResumedView;

import java.text.MessageFormat;
import java.util.Map;

public class SaveUserController {
    public static String saveUserController(Map request) {
        Either<UserWarnings, User> userCreated = UserDto.createUserFromRequest(request);
        if (userCreated.isLeft()) {
            return "Code Status 500: " + userCreated.getLeft().getWarnings();
        }
        try {
            SaveUser saveUserUseCase = new SaveUser(new UserRepositoryAlwaysSaveMockAdapter());
            User user = userCreated.get();
            Either<SaveUserWarning, User> saveUser = saveUserUseCase.saveUser(user);
            if (saveUser.isLeft()) {
                return "Code Status 500: " + saveUser.getLeft().toString();
            }
            UserResumedView userResumedView = new UserResumedView(user.getUsername(), user.getEmail());
            return MessageFormat.format("Code Status 200: User: {0} {1} created successfully", userResumedView.name, userResumedView.email);
        } catch (Exception unknownException) {
            return "Code Status 501: " + unknownException.getMessage();
        }
    }
}
