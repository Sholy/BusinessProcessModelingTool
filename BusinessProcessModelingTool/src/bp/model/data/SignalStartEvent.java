package bp.model.data;

public class SignalStartEvent extends StartEvent {

    private String dataFormat;
    private String signalName;

    public SignalStartEvent(String uniqueName) {
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

}
