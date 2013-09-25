package bp.model.data;

import bp.details.ErrorStartEventDetails;
import bp.model.graphic.EventComponent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;
import bp.util.ImageRes;

public class ErrorStartEvent extends StartEvent {

    private String errorName;

    public ErrorStartEvent(final String uniqueName) {
        super(uniqueName);
    }

    public String getErrorName() {
        return this.errorName;
    }

    public void updateErrorName(final String errorName, final Controller source) {
        this.errorName = errorName;
        fireAttributeChanged(BPKeyWords.ERROR_NAME, this.errorName, source);
    }

    @Override
    protected void initializeComponent() {
        this.component = new EventComponent(this, ImageRes.ERROR, null);
        this.component.setzIndex(101);
    }

    @Override
    protected void initializeDetails() {
        this.details = new ErrorStartEventDetails(this);
    }

}
