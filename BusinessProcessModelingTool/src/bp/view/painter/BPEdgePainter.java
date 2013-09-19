package bp.view.painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import bp.model.graphic.BPEdge;
import bp.model.graphic.util.EdgeHandlers;
import bp.view.BasicPainter;

public class BPEdgePainter extends BasicPainter {

    private final BPEdge edge = (BPEdge) getElement();

    public BPEdgePainter(BPEdge edge) {
        super(edge);
    }

    protected BPEdge getEdge() {
        return edge;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setPaint(getEdge().getFgColor());
        g.setStroke(getEdge().getFgStroke());
        g.drawLine(edge.getSourceX(), edge.getSourceY(), edge.getTargetX(), edge.getTargetY());

        Integer x1 = getEdge().getSourceX();
        Integer y1 = getEdge().getSourceY();
        Integer x2 = getEdge().getTargetX();
        Integer y2 = getEdge().getTargetY();

        Double angle = null;

        if (x1 == x2) {
            if (y2 > y1) {
                angle = -Math.PI / 2;
            } else if (y1 > y2) {
                angle = Math.PI / 2;
            } else {
            angle = 0d;
            }
        }
        if (y1 == y2 && angle == null) {
            if (x1 > x2) {
                angle = Math.PI;
            } else {
                angle = 0d;
            }
        }
        if (angle == null) {
            angle = Math.atan(((double) (y1 - y2)) / ((double) (x2 - x1)));
            if (x1 > x2)
                angle += Math.PI;
        }
        
        AffineTransform oldTransform = g.getTransform();

        g.translate(x2, y2);

        g.rotate(-angle);

        g.draw(getEdge().getEndShape());
        g.fill(getEdge().getEndShape());

        g.setTransform(oldTransform);

    }

    @Override
    public boolean isElementAt(Point pos) {
        Integer x1 = getEdge().getSourceX();
        Integer y1 = getEdge().getSourceY();
        Integer x2 = getEdge().getTargetX();
        Integer y2 = getEdge().getTargetY();

        GeneralPath gp = new GeneralPath();
        gp.moveTo(x1 - 5, y1);
        gp.lineTo(x2 - 5, y2);
        gp.lineTo(x2 + 5, y2);
        gp.lineTo(x1 + 5, y1);
        gp.lineTo(x1 - 5, y1);

        return gp.contains(pos);
    }

    @Override
    public void paintHandlers(Graphics2D g) {
        EdgeHandlers handlers = getEdge().getHandlers();
        if (handlers == null)
            return;

        g.setPaint(handlers.getLineColor());
        g.setStroke(handlers.getLineStroke());
        g.drawLine(edge.getSourceX(), edge.getSourceY(), edge.getTargetX(), edge.getTargetY());

        if (handlers.getSource() != null)
            paintHandler(g, handlers.getSource());
        if (handlers.getTarget() != null)
            paintHandler(g, handlers.getTarget());
    }

}
