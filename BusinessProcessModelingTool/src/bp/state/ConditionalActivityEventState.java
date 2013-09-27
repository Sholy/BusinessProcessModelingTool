package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.ConditionalActivityEvent;
import bp.model.data.Element;
import bp.model.data.Task;
import bp.util.ActivityEventLocationHelper;

public class ConditionalActivityEventState extends BPState {

    public ConditionalActivityEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final Element el = getGraphicPanel().getElementAt(p);
        if (el != null) {
            if (el instanceof Task) {
                final Task taskElement = (Task) el;
                final ConditionalActivityEvent event = new ConditionalActivityEvent("untitledEvent");
                event.getEventComponent().setX(p.x);
                event.getEventComponent().setY(p.y);
                final Point validPoint = ActivityEventLocationHelper.getValidPoint(taskElement.getTaskComponent(),
                        event.getEventComponent(), p);
                event.getEventComponent().setX(validPoint.x);
                event.getEventComponent().setY(validPoint.y);
                event.updateActivity(taskElement, null);

                getPanel().getProcess().addElement(event);
                getPanel().repaint();
            }
        }

    }

    @Override
    public void enteringState() {
        System.out.println("entering conditional activity event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting conditonal activity event state");
    }

}
