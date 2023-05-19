package org.mousekata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MouseTest {
    /*
    *   1. If user make one click within 500ms, mouse will subscribe a single click.
    *   2. If user make two clicks within 500ms, mouse will subscribe a double click.
    */
    Mouse mouse;
    MouseEventListener listener;
    @BeforeEach
     void setUp() {
         mouse = new Mouse();
         listener = mock(MouseEventListener.class);
         mouse.subscribe(listener);
     }
    @Test
    void shouldMakeASingleClick() {
        mouse.pressLeftButton(0, 0, 0);
        mouse.releaseLeftButton(0,0,0);
        mouse.manageClicks();
        System.out.println(ClickManager.clicks);
        verify(listener).handleMouseEvent(MouseEventType.SingleClick);
    }

    @Test
    void shouldMakeADoubleClick() {
        mouse.pressLeftButton(0, 0, 0);
        mouse.releaseLeftButton(0,0,0);
        mouse.pressLeftButton(0, 0, 0);
        mouse.releaseLeftButton(0,0,0);
        mouse.manageClicks();
        verify(listener).handleMouseEvent(MouseEventType.DoubleClick);
    }

    @Test
    void shouldMakeATripleClick() {
        mouse.pressLeftButton(0, 0, 0);
        mouse.releaseLeftButton(0,0,0);
        mouse.pressLeftButton(0, 0, 0);
        mouse.releaseLeftButton(0,0,0);
        mouse.pressLeftButton(0, 0, 0);
        mouse.releaseLeftButton(0,0,0);
        mouse.manageClicks();
        verify(listener).handleMouseEvent(MouseEventType.TripleClick);
    }
}
