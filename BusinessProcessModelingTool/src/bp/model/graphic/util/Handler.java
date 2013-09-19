package bp.model.graphic.util;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;

import bp.model.graphic.BPGraphElement;
import bp.view.painter.BPShapeFactory;

public class Handler extends BPGraphElement {

    private Integer x;
    private Integer y;
    private final Integer width;
    private final Integer height;

    private final HandlerPosition handlerPosition;

    public Handler(HandlerPosition handlerPosition) {
        this.handlerPosition = handlerPosition;

        setFgColor(Color.BLACK);
        setBgColor(Color.BLACK);

        setX(0);
        setY(0);
        width = 6;
        height = 6;

    }

    public Handler(Integer x, Integer y, HandlerPosition handlerPosition) {
        this(handlerPosition);
        setX(x);
        setY(y);
    }

    public Shape getShape() {
        return BPShapeFactory.handler(this);
    }


    public HandlerPosition getHandlerPosition() {
        return handlerPosition;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public boolean isAt(Point p) {
        if (p.x >= x && p.x <= x + width && p.y >= y && p.y <= y + height)
            return true;

        return false;
    }
}
