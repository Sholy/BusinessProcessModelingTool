package bp.model.graphic.util;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;

import bp.model.graphic.BPEdge;
import bp.view.Strokes;

public class EdgeHandlers {

    private final BPEdge edge;

    private Stroke lineStroke = Strokes.getLine(Strokes.THIN_LINE);
    private Color lineColor = Color.BLACK;

    private Handler source;
    private Handler target;

    public EdgeHandlers(BPEdge edge) {
        this.edge = edge;

        initializeHandlers();
        updateHandlers();
    }

    public void updateHandlers() {
        source.setX(getEdge().getSourceX() - source.getWidth()/2);
        source.setY(getEdge().getSourceY() - source.getHeight()/2);

        target.setX(getEdge().getTargetX() - target.getWidth() / 2);
        target.setY(getEdge().getTargetY() - target.getHeight() / 2);
    }

    private void initializeHandlers() {
        source = new Handler(0, 0, HandlerPosition.SOURCE);
        target = new Handler(0, 0, HandlerPosition.TARGET);
    }

    public BPEdge getEdge() {
        return edge;
    }

    public Stroke getLineStroke() {
        return lineStroke;
    }

    public void setLineStroke(Stroke lineStroke) {
        this.lineStroke = lineStroke;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Handler getSource() {
        return source;
    }

    public Handler getTarget() {
        return target;
    }

    public boolean isHandlerAt(Point p) {
        return source.isAt(p) || target.isAt(p);
    }

    public Handler getHandlerAt(Point p) {
        if (source.isAt(p))
            return source;
        if (target.isAt(p))
            return target;

        return null;
    }

}
