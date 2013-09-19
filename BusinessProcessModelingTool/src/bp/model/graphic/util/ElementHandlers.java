package bp.model.graphic.util;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;

import bp.model.graphic.BPComponent;
import bp.view.Strokes;
import bp.view.painter.BPShapeFactory;

public class ElementHandlers {

    public static final Integer RECTANGLE_HANDLERS = 0;
    public static final Integer SQUARE_HANDLERS = 1;

    private final BPComponent component;
    private final Integer handlerType;

    private Stroke lineStroke = Strokes.getDashedLine(Strokes.THIN_LINE);
    private Color lineColor = Color.BLACK;

    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;

    private Handler nw;
    private Handler ne;
    private Handler se;
    private Handler sw;
    private Handler n;
    private Handler e;
    private Handler s;
    private Handler w;
    

    public ElementHandlers(BPComponent component, Integer handlerType) {
        this.component = component;
        this.handlerType = handlerType;

        initializeHandlers();
        updateHandlers();
    }


    private void initializeHandlers() {
        initializeSquareHandlers();
        if (handlerType == RECTANGLE_HANDLERS)
            initializeRectangleHandlers();
    }

    private void initializeSquareHandlers() {
        nw = new Handler(0, 0, HandlerPosition.NORTH_WEST);
        ne = new Handler(0, 0, HandlerPosition.NORTH_EAST);
        sw = new Handler(0, 0, HandlerPosition.SOUTH_WEST);
        se = new Handler(0, 0, HandlerPosition.SOUTH_EAST);
    }

    private void initializeRectangleHandlers() {
        n = new Handler(0, 0, HandlerPosition.NORTH);
        e = new Handler(0, 0, HandlerPosition.EAST);
        s = new Handler(0, 0, HandlerPosition.SOUTH);
        w = new Handler(0, 0, HandlerPosition.WEST);
    }

    public void updateHandlers() {
        Integer x = getComponent().getX();
        Integer y = getComponent().getY();
        Integer w = getComponent().getWidth();
        Integer h = getComponent().getHeight();
        
        this.x = x - 3;
        this.y = y - 3;
        this.width = w + 6;
        this.height = h + 6;

        this.nw.setX(x - this.nw.getWidth());
        this.nw.setY(y - this.nw.getHeight());

        this.ne.setX(x + w);
        this.ne.setY(y - this.ne.getHeight());
        
        this.se.setX(x + w);
        this.se.setY(y + h);

        this.sw.setX(x - this.sw.getWidth());
        this.sw.setY(y + h);

        if (handlerType == RECTANGLE_HANDLERS) {
            this.n.setX(x + (w - this.n.getWidth()) / 2);
            this.n.setY(y - this.n.getHeight());

            this.e.setX(x + w);
            this.e.setY(y + (h - this.e.getHeight()) / 2);

            this.s.setX(x + (w - this.s.getWidth()) / 2);
            this.s.setY(y + h);

            this.w.setX(x - this.w.getWidth());
            this.w.setY(y + (h - this.w.getHeight()) / 2);
        }
    }

    public BPComponent getComponent() {
        return component;
    }

    public Integer getHandlerType() {
        return handlerType;
    }

    public Handler getNw() {
        return nw;
    }

    public Handler getNe() {
        return ne;
    }

    public Handler getSe() {
        return se;
    }

    public Handler getSw() {
        return sw;
    }

    public Handler getN() {
        return n;
    }

    public Handler getE() {
        return e;
    }

    public Handler getS() {
        return s;
    }

    public Handler getW() {
        return w;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
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

    public Shape getShape() {
        return BPShapeFactory.handlerBorder(this);
    }

    public boolean isHandlerAt(Point p) {
        Boolean squareHandlers = nw.isAt(p) || ne.isAt(p) || se.isAt(p) || sw.isAt(p);
        if (handlerType == RECTANGLE_HANDLERS) {
            Boolean rectangleHandlers = n.isAt(p) || e.isAt(p) || s.isAt(p) || w.isAt(p);
            return squareHandlers || rectangleHandlers;
        }
        return squareHandlers;
    }

    public Handler getHandlerAt(Point p) {
        if (nw.isAt(p))
            return nw;
        if (ne.isAt(p))
            return ne;
        if (se.isAt(p))
            return se;
        if (sw.isAt(p))
            return sw;
        if (handlerType == RECTANGLE_HANDLERS) {
            if (n.isAt(p))
                return n;
            if (e.isAt(p))
                return e;
            if (s.isAt(p))
                return s;
            if (w.isAt(p))
                return w;
        }
        
        return null;
    }

}
