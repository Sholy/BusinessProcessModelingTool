package bp.model.data;

/**
 * Connects Vertices under some condition
 * 
 * @author Sholy
 * 
 */
public class ConditionalEdge extends Edge {

    private String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public ConditionalEdge(String uniqueName) {
        super(uniqueName);
    }

}
