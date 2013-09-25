package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.SignalStartEvent;

public class SignalStartEventState extends BPState {

    public SignalStartEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final SignalStartEvent event = new SignalStartEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering signal start event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting signal start event state");
    }

}
