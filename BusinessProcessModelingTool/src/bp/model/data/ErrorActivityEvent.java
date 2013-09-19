package bp.model.data;

public class ErrorActivityEvent extends ActivityEvent {

    private String errorName;

    public ErrorActivityEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

}
