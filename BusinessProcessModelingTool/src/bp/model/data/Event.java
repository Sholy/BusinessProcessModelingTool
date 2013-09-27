package bp.model.data;

import bp.model.graphic.EventComponent;

public abstract class Event extends Vertex {

    public Event(final String uniqueName) {
        super(uniqueName);
    }

    public EventComponent getEventComponent() {
        return (EventComponent) getComponent();
    }

}
