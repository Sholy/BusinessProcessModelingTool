package bp.model.data;

public class MessageActivityEvent extends ActivityEvent {

    private String dataFormat;
    private Boolean stopActivity;

    public MessageActivityEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public Boolean getStopActivity() {
        return stopActivity;
    }

    public void setStopActivity(Boolean stopActivity) {
        this.stopActivity = stopActivity;
    }

}
