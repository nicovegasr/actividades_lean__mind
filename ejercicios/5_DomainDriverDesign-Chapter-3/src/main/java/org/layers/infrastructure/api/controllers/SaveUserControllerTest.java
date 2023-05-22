package org.layers.infrastructure.api.controllers;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.layers.infrastructure.api.controllers.SaveUserController.saveUserController;

public class SaveUserControllerTest {
    Map<String, Object> body;
    Map<String, Object> badBody;
    @BeforeEach
    public void setUp() {
        body = new HashMap<>();
        body.put("name", "prueba");
        body.put("email", "prueba@gmail.com");
        body.put("password", "password");
        body.put("age", 30);

        badBody = new HashMap<>();
        badBody.put("name", "");
        badBody.put("email", "prueba.com");
        badBody.put("password", "word");
        badBody.put("age", 12);
    }
    @Test
    public void shouldSaveUserController() {
        String response = saveUserController(body);
        assertEquals("Code Status 200: User: prueba prueba@gmail.com created successfully", response);
    }

    @Test
    public void shouldNotCreateUserFromDto() {
        String response = saveUserController(badBody);
        assertEquals("Code Status 500: AGE_UNDER_LIMIT INCORRECT_EMAIL_FORMAT NAME_CANNOT_BE_EMPTY", response);
    }
}
