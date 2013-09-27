package bp.model.data;

import bp.details.SignalThrowEventDetails;
import bp.model.graphic.EventComponent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;
import bp.util.ImageRes;
import bp.view.Strokes;

public class SignalThrowEvent extends ThrowEvent {

    private String signalData;
    private String signalName;

    public SignalThrowEvent(final String uniqueName) {
        super(uniqueName);
    }

    public String getSignalData() {
        return this.signalData;
    }

    public void updateSignalData(final String signalData, final Controller source) {
        this.signalData = signalData;
        fireAttributeChanged(BPKeyWords.SIGNAL_DATA, this.signalData, source);
    }

    public String getSignalName() {
        return this.signalName;
    }

    public void updateSignalName(final String signalName, final Controller source) {
        this.signalName = signalName;
        fireAttributeChanged(BPKeyWords.SIGNAL_NAME, this.signalName, source);
    }

    @Override
    protected void initializeComponent() {
        this.component = new EventComponent(this, ImageRes.SIGNAL, Strokes.getDashedLine(Strokes.THICK_LINE));
        this.component.setzIndex(101);
    }

    @Override
    protected void initializeDetails() {
        this.details = new SignalThrowEventDetails(this);
    }
}
