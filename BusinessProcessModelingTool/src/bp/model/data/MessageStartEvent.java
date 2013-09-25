package bp.model.data;

import bp.details.MessageStartEventDetails;
import bp.model.graphic.EventComponent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;
import bp.util.ImageRes;

public class MessageStartEvent extends StartEvent {

    private String dataFormat;

    public MessageStartEvent(final String uniqueName) {
        super(uniqueName);
    }

    public String getDataFormat() {
        return this.dataFormat;
    }

    public void updateDataFormat(final String dataFormat, final Controller source) {
        this.dataFormat = dataFormat;
        fireAttributeChanged(BPKeyWords.DATA_FORMAT, this.dataFormat, source);
    }

    @Override
    protected void initializeComponent() {
        this.component = new EventComponent(this, ImageRes.MESSAGE, null);
        this.component.setzIndex(101);
    }

    @Override
    protected void initializeDetails() {
        this.details = new MessageStartEventDetails(this);
    };

}
