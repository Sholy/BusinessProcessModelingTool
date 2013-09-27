package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.Element;
import bp.model.data.Task;
import bp.model.data.TimerActivityEvent;
import bp.util.ActivityEventLocationHelper;

public class TimerActivityEventState extends BPState {

    public TimerActivityEventState(final BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        final Element el = getGraphicPanel().getElementAt(p);
        if (el != null) {
            if (el instanceof Task) {
                final Task taskElement = (Task) el;
                final TimerActivityEvent event = new TimerActivityEvent("untitledEvent");
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
        System.out.println("entering timer activity event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting timer activity event state");
    }

}
