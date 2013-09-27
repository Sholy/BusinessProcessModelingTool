package bp.model.data;

import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public abstract class IntermediateEvent extends Event {

    private Integer minInput;

    public IntermediateEvent(final String uniqueName) {
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

    public Integer getMinInput() {
        return this.minInput;
    }

    public void updateMinInput(final Integer minInput, final Controller source) {
        this.minInput = minInput;
        fireAttributeChanged(BPKeyWords.MIN_INPUT, this.minInput, source);
    }

}
