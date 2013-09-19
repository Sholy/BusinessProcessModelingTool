package bp.model.data;

public abstract class ThrowEvent extends IntermediateEvent {

    private Long maxTriggers;

    public ThrowEvent(String uniqueName) {
        super(uniqueName);
    }

    public Long getMaxTriggers() {
        return maxTriggers;
    }

    public void setMaxTriggers(Long maxTriggers) {
        this.maxTriggers = maxTriggers;
    }

}
