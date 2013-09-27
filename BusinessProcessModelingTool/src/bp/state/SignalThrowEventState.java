package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.SignalThrowEvent;

public class SignalThrowEventState extends BPState {

    public SignalThrowEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final SignalThrowEvent event = new SignalThrowEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering signal throw event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting signal throw event state");
    }

}
