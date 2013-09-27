package bp.model.data;

import bp.details.ErrorEndEventDetails;
import bp.model.graphic.EventComponent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;
import bp.util.ImageRes;
import bp.view.Strokes;

public class ErrorEndEvent extends SingleEndEvent {

    private String errorData;
    private String errorName;

    public ErrorEndEvent(final String uniqueName) {
        super(uniqueName);
    }

    public String getErrorData() {
        return this.errorData;
    }

    public void updateErrorData(final String errorData, final Controller source) {
        this.errorData = errorData;
        fireAttributeChanged(BPKeyWords.ERROR_DATA, this.errorData, source);
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
        this.component = new EventComponent(this, ImageRes.ERROR, Strokes.getLine(Strokes.THICK_LINE));
        this.component.setzIndex(101);
    }

    @Override
    protected void initializeDetails() {
        this.details = new ErrorEndEventDetails(this);
    }

}
