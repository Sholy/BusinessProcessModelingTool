package bp.model.data;

public class SignalCatchEvent extends CatchEvent {

    private String dataFormat;
    private String signalName;

    public SignalCatchEvent(String uniqueName) {
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
