package bp.model.data;

public class TimerStartEvent extends StartEvent {

    private String timeFormat;

    public TimerStartEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

}
