package bp.model.data;

import bp.details.EndEventDetails;
import bp.model.graphic.EventComponent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;
import bp.view.Strokes;

public class EndEvent extends Event {

    private Integer minInput;

    public EndEvent(final String uniqueName) {
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

    public Integer getMinInput() {
        return this.minInput;
    }

    public void updateMinInput(final Integer minInput, final Controller source) {
        this.minInput = minInput;
        fireAttributeChanged(BPKeyWords.MIN_INPUT, this.minInput, source);
    }

    @Override
    protected void initializeComponent() {
        this.component = new EventComponent(this, null, Strokes.getLine(Strokes.THICK_LINE));
        this.component.setzIndex(101);
    }

    @Override
    protected void initializeDetails() {
        this.details = new EndEventDetails(this);
    }

}
