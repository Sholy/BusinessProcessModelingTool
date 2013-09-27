package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.MessageCatchEvent;

public class MessageCatchEventState extends BPState {

    public MessageCatchEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final MessageCatchEvent event = new MessageCatchEvent("untitledEvent");
        event.getEventComponent().setX(p.x);
        event.getEventComponent().setY(p.y);

        getPanel().getProcess().addElement(event);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering message catch event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting message catch event state");
    }

}
