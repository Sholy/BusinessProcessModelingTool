package bp.model.data;

public class ErrorEndEvent extends SingleEndEvent {

    private String errorData;
    private String errorName;

    public ErrorEndEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getErrorData() {
        return errorData;
    }

    public void setErrorData(String errorData) {
        this.errorData = errorData;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

}
