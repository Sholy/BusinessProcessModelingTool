package bp.model.data;

public class MessageCatchEvent extends CatchEvent {

    private String dataFormat;

    public MessageCatchEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }


}
