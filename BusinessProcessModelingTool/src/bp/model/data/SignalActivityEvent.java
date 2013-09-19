package bp.model.data;

public class SignalActivityEvent extends ActivityEvent {

    private String dataFormat;
    private String signalName;
    private Boolean stopActivity;

    public SignalActivityEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }

    public Boolean getStopActivity() {
        return stopActivity;
    }

    public void setStopActivity(Boolean stopActivity) {
        this.stopActivity = stopActivity;
    }

}
