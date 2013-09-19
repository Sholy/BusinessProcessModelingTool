package bp.model.data;

public class SignalThrowEvent extends ThrowEvent {

    private String signalData;
    private String signalName;

    public SignalThrowEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getSignalData() {
        return signalData;
    }

    public void setSignalData(String signalData) {
        this.signalData = signalData;
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }
}
