package bp.model.data;

import bp.details.EdgeDetails;
import bp.model.graphic.BPEdge;


/**
 * Edges of Business Process. They connect vertices.
 * 
 * @author Sholy
 * 
 */
public class Edge extends Element {

    private Vertex source;
    private Vertex target;

    public Edge(String uniqueName) {
        super(uniqueName);
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }

    public BPEdge getEdgeComponent() {
        return (BPEdge) getComponent();
    }

    @Override
    protected void initializeComponent() {
        component = new BPEdge();
    }

    @Override
    protected void initializeDetails() {
        details = new EdgeDetails(this);
    }

}
