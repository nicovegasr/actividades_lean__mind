package org.layers.infrastructure.database.repositories;

import org.layers.domain.interfaces.UserRepository;
import org.layers.domain.models.User;

public class UserRepositoryAlwaysSaveMockAdapter implements UserRepository {

    @Override
    public Boolean userExists(User user) {
        return false;
    }

    @Override
    public void saveUser(User user) {

    }
}
