package org.mousekata;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MouseTest {

    /*
    *   single click use case   ->  SingleClick
    */

    Mouse mouse;
    MouseEventListener listener;

    @BeforeEach
     void setUp() {
         mouse = new Mouse();
         listener = mock(MouseEventListener.class);
     }

    @Test
    void should_return_single_click_when_user_press_mouse_one_time_in_less_than_500_ms() {

        mouse.subscribe(listener);
        mouse.pressLeftButton(Timestamp.from(Instant.now()).getTime());
        mouse.releaseLeftButton(Timestamp.from(Instant.now()).getTime());

        verify(listener).handleMouseEvent(MouseEventType.SingleClick);
    }

    @Test
    void should_return_double_click_when_user_press_mouse_two_time_in_less_than_500_ms() {
        mouse.subscribe(listener);
        mouse.pressLeftButton(Timestamp.from(Instant.now()).getTime());
        mouse.releaseLeftButton(Timestamp.from(Instant.now()).getTime());
        mouse.pressLeftButton(Timestamp.from(Instant.now()).getTime());
        mouse.releaseLeftButton(Timestamp.from(Instant.now()).getTime());

        verify(listener).handleMouseEvent(MouseEventType.DoubleClick);
    }
}
