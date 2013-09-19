package bp.model.data;

public class MessageStartEvent extends StartEvent {

    private String dataFormat;

    public MessageStartEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

}
