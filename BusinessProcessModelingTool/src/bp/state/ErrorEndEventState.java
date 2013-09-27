package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.ErrorEndEvent;

public class ErrorEndEventState extends BPState {

    public ErrorEndEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final ErrorEndEvent event = new ErrorEndEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering error end event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting error end event state");
    }

}
