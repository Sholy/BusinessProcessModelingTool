package bp.model.data;

import java.util.ArrayList;
import java.util.List;

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

    public void setData(String data) {
        this.data = data;
    }

    public String getLoopExpression() {
        return loopExpression;
    }

    public void setLoopExpression(String loopExpression) {
        this.loopExpression = loopExpression;
    }

    public Integer getMinInput() {
        return minInput;
    }

    public void setMinInput(Integer minInput) {
        this.minInput = minInput;
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
