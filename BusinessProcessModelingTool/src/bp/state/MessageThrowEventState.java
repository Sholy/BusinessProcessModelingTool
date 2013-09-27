package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.MessageThrowEvent;

public class MessageThrowEventState extends BPState {

    public MessageThrowEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final MessageThrowEvent event = new MessageThrowEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering message throw event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting message throw event state");
    }

}
