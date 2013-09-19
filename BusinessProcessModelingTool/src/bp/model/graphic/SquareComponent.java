package bp.model.graphic;

/**
 * BPComponent which has same width and height
 * 
 * 
 * @author Sholy
 * 
 */
public abstract class SquareComponent extends BPComponent {

    // Implementation will take height to be main dimension

    @Override
    public final Integer getDefaultWidth() {
        return getDefaultHeight();
    }

    @Override
    public final Integer getWidth() {
        return getHeight();
    }

    @Override
    public final void setWidth(Integer width) {
        setHeight(width);
    }
}
