package bp.model.graphic;

import java.awt.Dimension;
import java.awt.Shape;

import bp.model.graphic.util.ElementHandlers;
import bp.util.EdgePoints;

public abstract class BPComponent extends BPElement {

    public static final Integer MAX_DIMENSION_COEFICIENT = 2;
    public static final Integer MIN_DIMENSION_COEFICIENT = 2;

    /**
     * X Coordinate
     */
    private Integer x;
    /**
     * Y Coordinate
     */
    private Integer y;
    /**
     * Current width
     */
    private Integer width;
    /**
     * Current height
     */
    private Integer height;

    protected ElementHandlers handlers;

    public BPComponent() {
        width = getDefaultWidth();
        height = getDefaultHeight();
        x = 0;
        y = 0;
        initializeElementHandlers();
    }

    public BPComponent(Integer x, Integer y) {
        this();
        setX(x);
        setY(y);
    }

    public abstract Integer getDefaultHeight();

    public abstract Integer getDefaultWidth();

    public abstract Shape getShape();

    protected abstract void initializeElementHandlers();

    public Integer getMaximumHeight() {
        return getDefaultHeight() * MAX_DIMENSION_COEFICIENT;
    }

    public Integer getMaximumWidth() {
        return getDefaultWidth() * MAX_DIMENSION_COEFICIENT;
    }

    public Integer getMinimumHeight() {
        return getDefaultHeight() / MIN_DIMENSION_COEFICIENT;
    }

    public Integer getMinimumWidth() {
        return getDefaultWidth() / MIN_DIMENSION_COEFICIENT;
    }

    public Dimension getMinimumSize() {
        return new Dimension(getMinimumWidth(), getMinimumHeight());
    }

    public Dimension getMaximumSize() {
        return new Dimension(getMaximumWidth(), getMaximumHeight());
    }

    public Dimension getDefaultSize() {
        return new Dimension(getDefaultWidth(), getDefaultHeight());
    }

    public Integer getHeight() {
        return this.height;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setHeight(Integer height) {
        this.height = height;
        updateComponent();
    }

    public void setWidth(Integer width) {
        this.width = width;
        updateComponent();
    }

    public Dimension getSize() {
        return new Dimension();
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

    public EdgePoints[] getValidEdgePoints() {
        return EdgePoints.values();
    }

    public ElementHandlers getHandlers() {
        return handlers;
    }

    public void updateComponent() {
        if (getWidth() < getMinimumWidth())
            setWidth(getMinimumWidth());
        else if (getWidth() > getMaximumWidth())
            setWidth(getMaximumWidth());

        if (getHeight() < getMinimumHeight())
            setHeight(getMinimumHeight());
        else if (getHeight() > getMaximumHeight())
            setHeight(getMaximumHeight());
    }
}