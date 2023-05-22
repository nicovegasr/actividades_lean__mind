package org.domain.interfaces;

import org.domain.models.User;

public interface UserRepository {
    Boolean userExists(User user);
    void saveUser(User user);
}
