package org.layers.domain.interfaces;

import org.layers.domain.models.User;

public interface UserRepository {
    Boolean userExists(User user);
    void saveUser(User user);
}
