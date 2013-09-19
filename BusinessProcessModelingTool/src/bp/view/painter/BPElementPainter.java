package bp.view.painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import bp.model.graphic.BPComponent;
import bp.model.graphic.util.ElementHandlers;
import bp.view.BasicPainter;

public class BPElementPainter extends BasicPainter {

    private final BPComponent component = (BPComponent) getElement();

    public BPElementPainter(BPComponent component) {
        super(component);
    }

    protected BPComponent getComponent() {
        return component;
    }

    @Override
    public void paint(Graphics2D g) {
        AffineTransform oldTransform = g.getTransform();

        g.translate(getComponent().getX(), getComponent().getY());

        g.setPaint(getComponent().getFgColor());
        g.setStroke(getComponent().getFgStroke());
        g.draw(getComponent().getShape());

        g.setPaint(getComponent().getBgColor());
        g.setStroke(getComponent().getBgStroke());
        g.fill(getComponent().getShape());

        g.setTransform(oldTransform);
    }

    @Override
    public boolean isElementAt(Point pos) {
        Integer x = getComponent().getX();
        Integer y = getComponent().getY();
        Integer w = getComponent().getWidth();
        Integer h = getComponent().getHeight();
        Rectangle2D area = new Rectangle2D.Double(x, y, w, h);
        return area.contains(pos);
    }

    @Override
    public void paintHandlers(Graphics2D g) {
        ElementHandlers handlers = getComponent().getHandlers();
        if (handlers == null)
            return;

        AffineTransform oldTransform = g.getTransform();

        g.translate(handlers.getX(), handlers.getY());

        g.setPaint(handlers.getLineColor());
        g.setStroke(handlers.getLineStroke());
        g.draw(handlers.getShape());

        g.setTransform(oldTransform);

        if (handlers.getNw() != null)
            paintHandler(g, handlers.getNw());
        if (handlers.getNe() != null)
            paintHandler(g, handlers.getNe());
        if (handlers.getSe() != null)
            paintHandler(g, handlers.getSe());
        if (handlers.getSw() != null)
            paintHandler(g, handlers.getSw());
        if (handlers.getN() != null)
            paintHandler(g, handlers.getN());
        if (handlers.getE() != null)
            paintHandler(g, handlers.getE());
        if (handlers.getS() != null)
            paintHandler(g, handlers.getS());
        if (handlers.getW() != null)
            paintHandler(g, handlers.getW());

    }
}
