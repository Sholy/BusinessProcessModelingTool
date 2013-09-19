package bp.model.data;

import java.util.ArrayList;
import java.util.List;

public class Lane extends Element {

    private String actor;
    private Lane parent;
    private final List<Lane> children = new ArrayList<Lane>();
    private final List<Task> tasks = new ArrayList<Task>();

    public Lane(String uniqueName) {
        super(uniqueName);
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

}
