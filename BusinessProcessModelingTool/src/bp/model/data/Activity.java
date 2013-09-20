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

    public Activity(String uniqueName) {
        super(uniqueName);
    }

    public String getData() {
        return data;
    }

    public void updateData(String data, Controller source) {
        this.data = data;
        fireAttributeChanged(BPKeyWords.DATA, this.data, source);
    }

    public String getLoopExpression() {
        return loopExpression;
    }

    public void updateLoopExpression(String loopExpression, Controller source) {
        this.loopExpression = loopExpression;
        fireAttributeChanged(BPKeyWords.LOOP_EXPRESSION, this.loopExpression, source);
    }

    public Integer getMinInput() {
        return minInput;
    }

    public void updateMinInput(Integer minInput, Controller source) {
        this.minInput = minInput;
        fireAttributeChanged(BPKeyWords.MIN_INPUT, this.minInput, source);
    }

    public List<ActivityEvent> getActivityEvents() {
        return activityEvents;
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
