package bp.model.data;

public class EndEvent extends Event {

    private Long minInput;

    public EndEvent(String uniqueName) {
        super(uniqueName);
    }

    @Override
    public boolean canHaveInput() {
        return true;
    }

    @Override
    public boolean canHaveOutput() {
        return false;
    }

    public Long getMinInput() {
        return minInput;
    }

    public void setMinInput(Long minInput) {
        this.minInput = minInput;
    }

}
