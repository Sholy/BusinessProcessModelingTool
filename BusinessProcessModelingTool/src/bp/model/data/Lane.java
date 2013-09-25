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

    public Lane(final String uniqueName) {
        super(uniqueName);
    }

    @Override
    protected void initializeComponent() {
        this.component = new LaneComponent(this);
        this.component.setzIndex(1);
    }

    @Override
    protected void initializeDetails() {
        this.details = new LaneDetails(this);
    }

    public Lane getParent() {
        return this.parent;
    }

    public void updateParent(final Lane parent, final Controller source) {
        this.parent = parent;
        fireAttributeChanged(BPKeyWords.PARENT, this.parent, source);
    }

    public List<Lane> getChildren() {
        return this.children;
    }

    public String getActor() {
        return this.actor;
    }

    public void updateActor(final String actor, final Controller source) {
        this.actor = actor;
        fireAttributeChanged(BPKeyWords.ACTOR, this.actor, source);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public LaneComponent getLaneComponent() {
        return (LaneComponent) getComponent();
    }

}
