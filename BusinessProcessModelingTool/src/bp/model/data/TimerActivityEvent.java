package bp.model.data;

public class TimerActivityEvent extends ActivityEvent {

    private String timeFormat;
    private Boolean stopActivity;

    public TimerActivityEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public Boolean getStopActivity() {
        return stopActivity;
    }

    public void setStopActivity(Boolean stopActivity) {
        this.stopActivity = stopActivity;
    }

}
