package bp.model.data;

public class MessageEndEvent extends SingleEndEvent {

    private String message;

    public MessageEndEvent(String uniqueName) {
        super(uniqueName);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
