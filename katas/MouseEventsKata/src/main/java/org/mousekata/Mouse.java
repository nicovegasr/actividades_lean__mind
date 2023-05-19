package org.mousekata;

import java.util.ArrayList;
import java.util.List;

public class Mouse {
    private List<MouseEventListener> listeners = new ArrayList<>();
    private final long timeLimit = 500;
    public void pressLeftButton(int coordinateX, int coordinateY, long currentTime) {
        Click click = new Click(coordinateX, coordinateY, currentTime);
        ClickManager.addClick(click);
    }
    public void releaseLeftButton(int coordinateX, int coordinateY, long currentTime) {
        Click click = new Click(coordinateX, coordinateY, currentTime);
        ClickManager.addClick(click);
    }
    public void manageClicks() {
        ClickManager.resolveEvent().forEach(event -> {
            this.notifySubscribers(event);
        });
    }
    public void subscribe(MouseEventListener listener) {
        listeners.add(listener);
    }

    private void notifySubscribers(MouseEventType eventType) {
        listeners.forEach(listener -> listener.handleMouseEvent(eventType));
    }

}
