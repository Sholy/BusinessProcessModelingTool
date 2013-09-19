package bp.model.data;

/**
 * Task specialization - to be performed by machine
 * 
 * @author Sholy
 * 
 */
public class SystemTask extends Task {

    private String implementation;

    public SystemTask(String uniqueName) {
        super(uniqueName);
    }

    public String getImplementation() {
        return implementation;
    }

    public void setImplementation(String implementation) {
        this.implementation = implementation;
    }

}
