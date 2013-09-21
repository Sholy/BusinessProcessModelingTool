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

    public MoveState(BPPanel panel) {
        super(panel);
        draggedComponent = null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (draggedComponent == null) {
            for (Element el : getPanel().getProcess().getElements()) {
                if (el.getComponent().getPainter().isElementAt(e.getPoint())) {
                    BPElement bpEl = el.getComponent();
                    if (bpEl instanceof BPComponent) {
                        draggedComponent = (BPComponent) bpEl;
                        if (el instanceof Vertex) {
                            draggedVertex = (Vertex) el;
                        }
                        startX = e.getPoint().x;
                        startY = e.getPoint().y;
                        break;
                    }

                }
            }
        }

        if (draggedComponent == null) {
            getPanel().getStateManager().moveToState(StateType.SELECT);
        } else {
            draggedComponent.setX(draggedComponent.getX() + e.getPoint().x - startX);
            draggedComponent.setY(draggedComponent.getY() + e.getPoint().y - startY);
            if (draggedVertex != null) {
                for (Edge edge : draggedVertex.getInputEdges()) {
                    edge.getEdgeComponent().setTargetX(edge.getEdgeComponent().getTargetX() + e.getPoint().x - startX);
                    edge.getEdgeComponent().setTargetY(edge.getEdgeComponent().getTargetY() + e.getPoint().y - startY);
                }
                for (Edge edge : draggedVertex.getOutputEdges()) {
                    edge.getEdgeComponent().setSourceX(edge.getEdgeComponent().getSourceX() + e.getPoint().x - startX);
                    edge.getEdgeComponent().setSourceY(edge.getEdgeComponent().getSourceY() + e.getPoint().y - startY);
                }
            }
            getGraphicPanel().repaint();

            startX = e.getPoint().x;
            startY = e.getPoint().y;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        draggedComponent = null;
        draggedVertex = null;
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
