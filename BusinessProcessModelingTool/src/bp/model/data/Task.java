package bp.model.data;

import bp.details.TaskDetails;
import bp.model.graphic.TaskComponent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

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

    public void updateActor(String actor, Controller source) {
        this.actor = actor;
        fireAttributeChanged(BPKeyWords.ACTOR, this.actor, source);
    }

    public Boolean getAutoAssign() {
        return autoAssign;
    }

    public void updateAutoAssign(Boolean autoAssign, Controller source) {
        this.autoAssign = autoAssign;
        fireAttributeChanged(BPKeyWords.AUTO_ASSIGN, this.autoAssign, source);
    }

    public Integer getMultipleExecution() {
        return multipleExecution;
    }

    public void updateMultipleExecution(Integer multipleExecution, Controller source) {
        this.multipleExecution = multipleExecution;
        fireAttributeChanged(BPKeyWords.MULTIPLE_EXECUTION, this.multipleExecution, source);
    }

    public ExecutionType getMultipleExecutionType() {
        return multipleExecutionType;
    }

    public void updateMultipleExecutionType(ExecutionType multipleExecutionType, Controller source) {
        this.multipleExecutionType = multipleExecutionType;
        fireAttributeChanged(BPKeyWords.MULTIPLE_EXECUTION_TYPE, this.multipleExecutionType, source);
    }

    public Lane getLaneActor() {
        return laneActor;
    }

    public void updateLaneActor(Lane laneActor, Controller source) {
        this.laneActor = laneActor;
        fireAttributeChanged(BPKeyWords.LANE_ACTOR, this.laneActor, source);
    }

    @Override
    protected void initializeComponent() {
        component = new TaskComponent(this);
    }

    @Override
    protected void initializeDetails() {
        details = new TaskDetails(this);
    }

    public TaskComponent getTaskComponent() {
        return (TaskComponent) getComponent();
    }

}
