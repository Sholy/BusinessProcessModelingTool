package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.ConditionalCatchEvent;

public class ConditionalCatchEventState extends BPState {

    public ConditionalCatchEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final ConditionalCatchEvent event = new ConditionalCatchEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering conditional catch event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting conditional catch event state");
    }

}
