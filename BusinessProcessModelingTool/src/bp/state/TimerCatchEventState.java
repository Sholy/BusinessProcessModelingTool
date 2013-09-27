package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.TimerCatchEvent;

public class TimerCatchEventState extends BPState {

    public TimerCatchEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final TimerCatchEvent event = new TimerCatchEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering timer catch event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting timer catch event state");
    }

}
