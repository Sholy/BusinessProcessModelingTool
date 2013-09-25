package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.ConditionalStartEvent;

public class ConditionalStartEventState extends BPState {

    public ConditionalStartEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final ConditionalStartEvent event = new ConditionalStartEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering conditional start event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting conditional start event state");
    }

}
