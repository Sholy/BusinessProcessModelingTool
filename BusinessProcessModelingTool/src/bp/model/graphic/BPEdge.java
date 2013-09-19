package bp.model.graphic;

import java.awt.Shape;

import bp.model.graphic.util.EdgeHandlers;
import bp.view.BasicPainter;
import bp.view.Strokes;
import bp.view.painter.BPEdgePainter;
import bp.view.painter.BPShapeFactory;

public class BPEdge extends BPElement {

    private final BPEdgePainter painter;

    private Integer sourceX;
    private Integer sourceY;
    private Integer targetX;
    private Integer targetY;

    private final EdgeHandlers handlers;

    public BPEdge() {
        sourceX = 0;
        sourceY = 0;
        targetX = 0;
        targetY = 0;

        painter = new BPEdgePainter(this);
        setFgStroke(Strokes.getLine(Strokes.EDGE_LINE));
        handlers = new EdgeHandlers(this);
    }

    public BPEdge(Integer x, Integer y) {
        this();
        sourceX = x;
        sourceY = y;
    }

    public Integer getSourceX() {
        return sourceX;
    }

    public void setSourceX(Integer sourceX) {
        this.sourceX = sourceX;
    }

    public Integer getSourceY() {
        return sourceY;
    }

    public void setSourceY(Integer sourceY) {
        this.sourceY = sourceY;
    }

    public Integer getTargetX() {
        return targetX;
    }

    public void setTargetX(Integer targetX) {
        this.targetX = targetX;
    }

    public Integer getTargetY() {
        return targetY;
    }

    public void setTargetY(Integer targetY) {
        this.targetY = targetY;
    }

    @Override
    public BasicPainter getPainter() {
        return painter;
    }

    public Shape getEndShape() {
        return BPShapeFactory.arrow();
    }

    public EdgeHandlers getHandlers() {
        return handlers;
    }
}
