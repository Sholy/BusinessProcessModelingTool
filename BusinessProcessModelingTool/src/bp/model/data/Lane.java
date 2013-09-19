package bp.model.data;

import java.util.ArrayList;
import java.util.List;

import bp.details.LaneDetails;
import bp.model.graphic.LaneComponent;

public class Lane extends Element {

    private String actor;
    private Lane parent;
    private final List<Lane> children = new ArrayList<Lane>();
    private final List<Task> tasks = new ArrayList<Task>();

    public Lane(String uniqueName) {
        super(uniqueName);
    }

    @Override
    protected void initializeComponent() {
        component = new LaneComponent();
    }

    @Override
    protected void initializeDetails() {
        details = new LaneDetails(this);
        details.updateComponents();
    }

    public Lane getParent() {
        return parent;
    }

    public void setParent(Lane parent) {
        this.parent = parent;
    }

    public List<Lane> getChildren() {
        return children;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public LaneComponent getLaneComponent() {
        return (LaneComponent) getComponent();
    }

}
