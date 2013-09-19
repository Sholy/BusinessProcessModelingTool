package bp.model.data;

public class ErrorStartEvent extends StartEvent {

    private String errorName;

    public ErrorStartEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

}
