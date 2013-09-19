package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.Edge;
import bp.model.data.Element;
import bp.model.data.Vertex;
import bp.model.graphic.BPComponent;
import bp.util.PointHelper;

public class EdgeState extends BPState {

    private Edge edge;

    public EdgeState(BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        Element element = getGraphicPanel().getElementAt(p);
        if (element instanceof Vertex) {
            Vertex vertex = (Vertex) element;
            if (edge == null) {
                edge = new Edge("untitledEdge");
                if (vertex.canHaveOutput()) {
                    edge.setSource(vertex);
                    BPComponent vertexComponent = (BPComponent) vertex.getComponent();
                    Integer x = vertexComponent.getX();
                    Integer y = vertexComponent.getY();
                    Integer w = vertexComponent.getWidth();
                    Integer h = vertexComponent.getHeight();
                    Point validPoint = PointHelper.findClosestPoint(vertexComponent.getValidEdgePoints(), p.x, p.y, x,
                            y, w, h);
                    edge.getEdgeComponent().setSourceX(validPoint.x);
                    edge.getEdgeComponent().setSourceY(validPoint.y);
                    edge.getEdgeComponent().setTargetX(validPoint.x);
                    edge.getEdgeComponent().setTargetY(validPoint.y);

                    getPanel().getProcess().getElements().add(edge);
                    // TODO: limit repaint region
                    getPanel().repaint();
                }
            } else {
                if (vertex.canHaveInput() && !vertex.equals(edge.getSource())) {
                    edge.setTarget(vertex);
                    edge.getSource().addOutputEdge(edge);
                    vertex.addInputEdge(edge);

                    BPComponent vertexComponent = (BPComponent) vertex.getComponent();
                    Integer x = vertexComponent.getX();
                    Integer y = vertexComponent.getY();
                    Integer w = vertexComponent.getWidth();
                    Integer h = vertexComponent.getHeight();
                    Point validPoint = PointHelper.findClosestPoint(vertexComponent.getValidEdgePoints(), p.x, p.y, x,
                            y, w, h);
                    edge.getEdgeComponent().setTargetX(validPoint.x);
                    edge.getEdgeComponent().setTargetY(validPoint.y);

                    edge.getEdgeComponent().getHandlers().updateHandlers();

                    // TODO: limit repaint region
                    getPanel().repaint();

                    edge = null;
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        if (edge != null) {
            edge.getEdgeComponent().setTargetX(p.x);
            edge.getEdgeComponent().setTargetY(p.y);

            // TODO: limit repaint region
            getPanel().repaint();
        }
    }

    @Override
    public void enteringState() {
        System.out.println("entering edge state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting edge state");
    }

    protected Edge getEdge() {
        return edge;
    }

}
