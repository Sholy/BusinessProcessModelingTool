package bp.model.data;

public class TimerCatchEvent extends CatchEvent {

    private String timeFormat;

    public TimerCatchEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }


}
