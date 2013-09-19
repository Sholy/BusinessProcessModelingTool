package bp.model.data;

import bp.app.AppCore;
import bp.details.TaskDetails;
import bp.model.graphic.TaskComponent;

/**
 * Task represents atomic unit of work
 * 
 * @author Sholy
 * 
 */
public class Task extends Activity {

    private String actor;
    private Lane laneActor;

    private Boolean autoAssign;
    private Integer multipleExecution;
    private ExecutionType multipleExecutionType;


    public Task(String uniqueName) {
        super(uniqueName);
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Boolean getAutoAssign() {
        return autoAssign;
    }

    public void setAutoAssign(Boolean autoAssign) {
        this.autoAssign = autoAssign;
    }

    public Integer getMultipleExecution() {
        return multipleExecution;
    }

    public void setMultipleExecution(Integer multipleExecution) {
        this.multipleExecution = multipleExecution;
    }

    public ExecutionType getMultipleExecutionType() {
        return multipleExecutionType;
    }

    public void setMultipleExecutionType(ExecutionType multipleExecutionType) {
        this.multipleExecutionType = multipleExecutionType;
    }

    public Lane getLaneActor() {
        return laneActor;
    }

    public void setLaneActor(Lane laneActor) {
        this.laneActor = laneActor;
    }

    @Override
    public void setName(String name) {
        // TODO change implementation
        if (name != null && !name.equals(getName())) {
            ((TaskComponent) component).updateText(name);
            AppCore.getInstance().getBpPanel().updateUI();
        }
        super.setName(name);
    }

    @Override
    protected void initializeComponent() {
        component = new TaskComponent();
    }

    @Override
    protected void initializeDetails() {
        details = new TaskDetails(this);
        details.updateComponents();
    }

    public TaskComponent getTaskComponent() {
        return (TaskComponent) getComponent();
    }

}
