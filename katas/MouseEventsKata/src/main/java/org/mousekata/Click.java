package org.mousekata;

public class Click {
    public long time;
    public final int coordinateX;
    public final int coordinateY;
    public Click(int coordinateX, int coordinateY, long time) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.time = time;
    }
}
