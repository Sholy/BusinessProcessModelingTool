package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.TimerStartEvent;

public class TimerStartEventState extends BPState {

    public TimerStartEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final TimerStartEvent event = new TimerStartEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering timer start event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting eimter start event state");
    }

}
