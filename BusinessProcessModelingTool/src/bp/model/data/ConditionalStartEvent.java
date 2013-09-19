package bp.model.data;

public class ConditionalStartEvent extends StartEvent {

    private String condition;

    public ConditionalStartEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
