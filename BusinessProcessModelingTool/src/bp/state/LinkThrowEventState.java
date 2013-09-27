package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.LinkThrowEvent;

public class LinkThrowEventState extends BPState {

    public LinkThrowEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final LinkThrowEvent event = new LinkThrowEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering link throw event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting link throw event state");
    }

}
