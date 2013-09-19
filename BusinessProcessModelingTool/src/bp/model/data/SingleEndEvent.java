package bp.model.data;

public abstract class SingleEndEvent extends EndEvent {

    private Long maxTriggers;

    public SingleEndEvent(String uniqueName) {
        super(uniqueName);
    }

    public Long getMaxTriggers() {
        return maxTriggers;
    }

    public void setMaxTriggers(Long maxTriggers) {
        this.maxTriggers = maxTriggers;
    }

}
