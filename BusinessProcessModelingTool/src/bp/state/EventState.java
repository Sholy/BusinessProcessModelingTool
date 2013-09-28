package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.ConditionalCatchEvent;
import bp.model.data.ConditionalStartEvent;
import bp.model.data.EndEvent;
import bp.model.data.ErrorEndEvent;
import bp.model.data.ErrorStartEvent;
import bp.model.data.Event;
import bp.model.data.LinkCatchEvent;
import bp.model.data.LinkThrowEvent;
import bp.model.data.MessageCatchEvent;
import bp.model.data.MessageEndEvent;
import bp.model.data.MessageStartEvent;
import bp.model.data.MessageThrowEvent;
import bp.model.data.SignalCatchEvent;
import bp.model.data.SignalEndEvent;
import bp.model.data.SignalStartEvent;
import bp.model.data.SignalThrowEvent;
import bp.model.data.StartEvent;
import bp.model.data.TimerCatchEvent;
import bp.model.data.TimerStartEvent;

public class EventState extends BPState {

    private final StateType eventType;

    public EventState(final BPPanel panel, final StateType eventType) {
        super(panel);
        if (eventType == null) {
            throw new IllegalArgumentException("eventType argument can't be null");
        }
        this.eventType = eventType;
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final Point p = e.getPoint();
        if (!getGraphicPanel().isElementAt(p)) {
            final Event event = createEvent();
            event.getEventComponent().setX(p.x);
            event.getEventComponent().setY(p.y);

            getPanel().getProcess().addElement(event);
            getPanel().repaint();
        }
    }

    @Override
    public void enteringState() {
        System.out.println("entering event state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting event state");
    }

    private Event createEvent() {
        if (this.eventType == StateType.START_EVENT) {
            return new StartEvent("a");
        }
        if (this.eventType == StateType.TIMER_START_EVENT) {
            return new TimerStartEvent("a");
        }
        if (this.eventType == StateType.CONDITIONAL_START_EVENT) {
            return new ConditionalStartEvent("a");
        }
        if (this.eventType == StateType.MESSAGE_START_EVENT) {
            return new MessageStartEvent("a");
        }
        if (this.eventType == StateType.SIGNAL_START_EVENT) {
            return new SignalStartEvent("a");
        }
        if (this.eventType == StateType.ERROR_START_EVENT) {
            return new ErrorStartEvent("a");
        }
        if (this.eventType == StateType.END_EVENT) {
            return new EndEvent("a");
        }
        if (this.eventType == StateType.MESSAGE_END_EVENT) {
            return new MessageEndEvent("a");
        }
        if (this.eventType == StateType.ERROR_END_EVENT) {
            return new ErrorEndEvent("a");
        }
        if (this.eventType == StateType.SIGNAL_END_EVENT) {
            return new SignalEndEvent("a");
        }
        if (this.eventType == StateType.TIMER_CATCH_EVENT) {
            return new TimerCatchEvent("a");
        }
        if (this.eventType == StateType.CONDITIONAL_CATCH_EVENT) {
            return new ConditionalCatchEvent("a");
        }
        if (this.eventType == StateType.MESSAGE_CATCH_EVENT) {
            return new MessageCatchEvent("a");
        }
        if (this.eventType == StateType.SIGNAL_CATCH_EVENT) {
            return new SignalCatchEvent("a");
        }
        if (this.eventType == StateType.LINK_CATCH_EVENT) {
            return new LinkCatchEvent("a");
        }
        if (this.eventType == StateType.MESSAGE_THROW_EVENT) {
            return new MessageThrowEvent("a");
        }
        if (this.eventType == StateType.SIGNAL_THROW_EVENT) {
            return new SignalThrowEvent("a");
        }
        if (this.eventType == StateType.LINK_THROW_EVENT) {
            return new LinkThrowEvent("a");
        }
        return null;
    }

}
