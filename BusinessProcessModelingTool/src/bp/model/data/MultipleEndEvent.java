package bp.model.data;

import java.util.ArrayList;
import java.util.List;

public class MultipleEndEvent extends EndEvent {

    private final List<MessageEndEvent> messageEndEvents = new ArrayList<MessageEndEvent>();
    private final List<ErrorEndEvent> errorEndEvents = new ArrayList<ErrorEndEvent>();
    private final List<SignalEndEvent> signalEndEvents = new ArrayList<SignalEndEvent>();

    public MultipleEndEvent(String uniqueName) {
        super(uniqueName);
    }

    public List<MessageEndEvent> getMessageEndEvents() {
        return messageEndEvents;
    }

    public List<ErrorEndEvent> getErrorEndEvents() {
        return errorEndEvents;
    }

    public List<SignalEndEvent> getSignalEndEvents() {
        return signalEndEvents;
    }

}
