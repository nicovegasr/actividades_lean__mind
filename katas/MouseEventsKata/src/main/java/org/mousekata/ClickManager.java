package org.mousekata;

import java.util.ArrayList;
import java.util.List;

public class ClickManager {

    public static List<Click> clicks = new ArrayList<>();
    public ClickManager() { }
    public static void addClick(Click click) {
        ClickManager.clicks.add(click);
    }

    public static List<MouseEventType> resolveEvent() {
        List<MouseEventType> events = new ArrayList<>();
        List<Click> clicks =  ClickManager.clicks;
        /*
            Estos if seguro pueden cambiarse y en caso de que se llame
            al management con solo un press quizas deberia fallar o no.
         */
        if (clicks.size() == 2) {
            /* Casos a estudiar:
                1.- Single Click.
                2.- Drag and Drop.
             */
            events.add(MouseEventType.SingleClick);
        } else if (clicks.size() == 4) {
            /* Casos a estudiar:
                1.- 2 Single CLick.
                2.- 1 Single Click y 1 Drag and drop
                3.- 1 Drag and drop y 1 Single Click
                4.- 2 Drag and drop.
                5.- 1 Doble Click.
             */
            events.add(MouseEventType.DoubleClick);
        } else if (clicks.size() == 6) {
            /* Casos a estudiar:
                Esto se va de las mano, seria mejor modular las dos soluciones
                anteriores antes de plantear todos los posibles casos
             */
            events.add(MouseEventType.TripleClick);
        }
        ClickManager.clicks = new ArrayList<>();
        return events;
    }
}
