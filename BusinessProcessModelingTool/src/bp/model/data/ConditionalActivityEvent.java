package bp.model.data;

public class ConditionalActivityEvent extends ActivityEvent {

    private String condition;
    private Boolean stopActivity;

    public ConditionalActivityEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Boolean getStopActivity() {
        return stopActivity;
    }

    public void setStopActivity(Boolean stopActivity) {
        this.stopActivity = stopActivity;
    }

}
