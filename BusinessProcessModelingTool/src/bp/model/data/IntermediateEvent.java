package bp.model.data;

public abstract class IntermediateEvent extends Event {

    private Long minInput;

    public IntermediateEvent(String uniqueName) {
        super(uniqueName);
    }

    @Override
    public boolean canHaveInput() {
        return true;
    }

    @Override
    public boolean canHaveOutput() {
        return true;
    }

    public Long getMinInput() {
        return minInput;
    }

    public void setMinInput(Long minInput) {
        this.minInput = minInput;
    }

}
