package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.ErrorStartEvent;

public class ErrorStartEventState extends BPState {

    public ErrorStartEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final ErrorStartEvent event = new ErrorStartEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering error start event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting error start event state");
    }

}
