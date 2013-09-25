package bp.model.data;

import bp.details.ConditionalStartEventDetails;
import bp.model.graphic.EventComponent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;
import bp.util.ImageRes;

public class ConditionalStartEvent extends StartEvent {

    private String condition;

    public ConditionalStartEvent(final String uniqueName) {
        super(uniqueName);
    }

    public String getCondition() {
        return this.condition;
    }

    public void updateCondition(final String condition, final Controller source) {
        this.condition = condition;
        fireAttributeChanged(BPKeyWords.CONDITION, this.condition, source);
    }

    @Override
    protected void initializeComponent() {
        this.component = new EventComponent(this, ImageRes.CONDITION, null);
        this.component.setzIndex(101);
    }

    @Override
    protected void initializeDetails() {
        this.details = new ConditionalStartEventDetails(this);
    }
}
