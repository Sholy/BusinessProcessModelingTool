package bp.model.data;

import java.util.ArrayList;
import java.util.List;

import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public abstract class Activity extends Vertex {

    private String data;
    private String loopExpression;
    private Integer minInput;

    private final List<ActivityEvent> activityEvents = new ArrayList<ActivityEvent>();

    public Activity(final String uniqueName) {
        super(uniqueName);
    }

    public String getData() {
        return this.data;
    }

    public void updateData(final String data, final Controller source) {
        this.data = data;
        fireAttributeChanged(BPKeyWords.DATA, this.data, source);
    }

    public String getLoopExpression() {
        return this.loopExpression;
    }

    public void updateLoopExpression(final String loopExpression, final Controller source) {
        this.loopExpression = loopExpression;
        fireAttributeChanged(BPKeyWords.LOOP_EXPRESSION, this.loopExpression, source);
    }

    public Integer getMinInput() {
        return this.minInput;
    }

    public void updateMinInput(final Integer minInput, final Controller source) {
        this.minInput = minInput;
        fireAttributeChanged(BPKeyWords.MIN_INPUT, this.minInput, source);
    }

    public List<ActivityEvent> getActivityEvents() {
        return this.activityEvents;
    }

    public void addActivityEvent(final ActivityEvent event) {
        this.activityEvents.add(event);
    }

    @Override
    public boolean canHaveInput() {
        return true;
    }

    @Override
    public boolean canHaveOutput() {
        return true;
    }

}
