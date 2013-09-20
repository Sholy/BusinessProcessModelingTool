package bp.model.data;

import java.util.ArrayList;
import java.util.List;

import bp.details.LaneDetails;
import bp.model.graphic.LaneComponent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

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
    }

    public Lane getParent() {
        return parent;
    }

    public void updateParent(Lane parent, Controller source) {
        this.parent = parent;
        fireAttributeChanged(BPKeyWords.PARENT, this.parent, source);
    }

    public List<Lane> getChildren() {
        return children;
    }

    public String getActor() {
        return actor;
    }

    public void updateActor(String actor, Controller source) {
        this.actor = actor;
        fireAttributeChanged(BPKeyWords.ACTOR, this.actor, source);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public LaneComponent getLaneComponent() {
        return (LaneComponent) getComponent();
    }

}
