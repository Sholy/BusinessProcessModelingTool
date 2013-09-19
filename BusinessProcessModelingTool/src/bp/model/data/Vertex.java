package bp.model.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Vertex elements of Business Process
 * 
 * @author Sholy
 * 
 */
public abstract class Vertex extends Element {

    private List<Edge> inputEdges;
    private List<Edge> outputEdges;

    public Vertex(String uniqueName) {
        super(uniqueName);
        initializeEdges();
    }

    private void initializeEdges() {
        if (canHaveInput()) {
            inputEdges = new ArrayList<Edge>();
        }
        if (canHaveOutput()) {
            outputEdges = new ArrayList<Edge>();
        }
    }

    /**
     * Returns true if vertex can have input (edge can end in this element)
     * 
     * @return
     */
    public abstract boolean canHaveInput();

    /**
     * Returns true if vertex can have output (edge can start from this element)
     * 
     * @return
     */
    public abstract boolean canHaveOutput();

    /**
     * Returns true if it has at least one input edge
     * 
     * @return
     */
    public boolean hasInput() {
        return !inputEdges.isEmpty();
    }

    public boolean hasOutput() {
        return !outputEdges.isEmpty();
    }

    public List<Edge> getInputEdges() {
        return inputEdges;
    }

    public List<Edge> getOutputEdges() {
        return outputEdges;
    }

    public void addOutputEdge(Edge edge) {
        if (canHaveOutput()) {
            outputEdges.add(edge);
        }
    }

    public void addInputEdge(Edge edge) {
        if (canHaveInput()) {
            inputEdges.add(edge);
        }
    }

}
