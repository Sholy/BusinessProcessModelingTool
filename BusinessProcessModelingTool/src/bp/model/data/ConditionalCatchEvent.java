package bp.model.data;

public class ConditionalCatchEvent extends CatchEvent {

    private String condition;

    public ConditionalCatchEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
