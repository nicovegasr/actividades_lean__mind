package org.layers.aplication.usecases;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import io.vavr.control.Either;
import org.junit.jupiter.api.*;

import org.layers.aplication.warnings.SaveUserWarning;
import org.layers.domain.interfaces.UserRepository;
import org.layers.domain.models.User;
import org.layers.domain.warnings.UserWarnings;


public class SaveUserTest {
    /**
    *  Use cases:
     *  1. Save user when user not exists.
     *  2. Return warning when user exists.
    */
    User user;
    UserRepository userRepository;
    @BeforeEach
    public void setUp() {
        Either<UserWarnings, User> userCreated = User.createUser("prueba", "prueba@gmail.com", 20, "password");
        user = userCreated.get();
        userRepository = mock(UserRepository.class);
    }
    @Test
    public void shouldSaveUser() {
        when(userRepository.userExists(user)).thenReturn(false);
        SaveUser saveUser = new SaveUser(userRepository);

        Either<SaveUserWarning, User> userSaved = saveUser.saveUser(user);
        User userFromDatabase = userSaved.get();

        verify(userRepository, times(1)).saveUser(user);
        assertEquals(userFromDatabase, user);
    }
    @Test
    public void shouldReturnWarningWhenUserExists() {
        when(userRepository.userExists(user)).thenReturn(true);
        SaveUser saveUser = new SaveUser(userRepository);

        Either<SaveUserWarning, User> userSaved = saveUser.saveUser(user);
        SaveUserWarning warning = userSaved.getLeft();

        verify(userRepository, times(0)).saveUser(user);
        assertEquals(warning, SaveUserWarning.USER_ALREADY_EXISTS);
    }
}
