package bp.model.data;

/**
 * Task specialization - to be performed by user with help of software
 * 
 * @author Sholy
 * 
 */
public class UserTask extends Task {

    private String impelemntation;

    public String getImpelemntation() {
        return impelemntation;
    }

    public void setImpelemntation(String impelemntation) {
        this.impelemntation = impelemntation;
    }

    public UserTask(String uniqueName) {
        super(uniqueName);
    }

}
