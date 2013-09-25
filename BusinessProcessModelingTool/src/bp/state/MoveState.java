package bp.state;

import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.Edge;
import bp.model.data.Element;
import bp.model.data.Vertex;
import bp.model.graphic.BPComponent;
import bp.model.graphic.BPElement;

public class MoveState extends BPState {

    private Vertex draggedVertex;
    private BPComponent draggedComponent;
    private Integer startX;
    private Integer startY;

    public MoveState(final BPPanel panel) {
        super(panel);
        this.draggedComponent = null;
    }

    @Override
    public void mouseDragged(final MouseEvent e) {
        if (this.draggedComponent == null) {
            final Element el = getGraphicPanel().getElementAt(e.getPoint());
            if (el != null) {
                final BPElement bpEl = el.getComponent();
                if (bpEl instanceof BPComponent) {
                    this.draggedComponent = (BPComponent) bpEl;
                    if (el instanceof Vertex) {
                        this.draggedVertex = (Vertex) el;
                    }
                    this.startX = e.getPoint().x;
                    this.startY = e.getPoint().y;
                }

            }
        }

        if (this.draggedComponent == null) {
            getPanel().getStateManager().moveToState(StateType.SELECT);
        } else {
            this.draggedComponent.setX(this.draggedComponent.getX() + e.getPoint().x - this.startX);
            this.draggedComponent.setY(this.draggedComponent.getY() + e.getPoint().y - this.startY);
            if (this.draggedVertex != null) {
                for (final Edge edge : this.draggedVertex.getInputEdges()) {
                    edge.getEdgeComponent().setTargetX(edge.getEdgeComponent().getTargetX() + e.getPoint().x - this.startX);
                    edge.getEdgeComponent().setTargetY(edge.getEdgeComponent().getTargetY() + e.getPoint().y - this.startY);
                }
                for (final Edge edge : this.draggedVertex.getOutputEdges()) {
                    edge.getEdgeComponent().setSourceX(edge.getEdgeComponent().getSourceX() + e.getPoint().x - this.startX);
                    edge.getEdgeComponent().setSourceY(edge.getEdgeComponent().getSourceY() + e.getPoint().y - this.startY);
                }
            }
            getGraphicPanel().repaint();

            this.startX = e.getPoint().x;
            this.startY = e.getPoint().y;
        }

    }

    @Override
    public void mouseReleased(final MouseEvent e) {
        this.draggedComponent = null;
        this.draggedVertex = null;
        getPanel().getStateManager().moveToState(StateType.SELECT);
    }

    @Override
    public void enteringState() {
        System.out.println("entering move state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting move state");

    }

}
