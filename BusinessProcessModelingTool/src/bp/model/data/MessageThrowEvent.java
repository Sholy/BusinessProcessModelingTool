package bp.model.data;

public class MessageThrowEvent extends ThrowEvent {

    private String message;

    public MessageThrowEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
