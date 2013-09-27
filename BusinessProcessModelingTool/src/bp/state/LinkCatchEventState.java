package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.LinkCatchEvent;

public class LinkCatchEventState extends BPState {

    public LinkCatchEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final LinkCatchEvent event = new LinkCatchEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering link catch state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting link catch state");
    }

}
