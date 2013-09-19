package bp.model.graphic;

import java.awt.Shape;

import bp.model.graphic.util.ElementHandlers;
import bp.util.StringUtils;
import bp.view.BasicPainter;
import bp.view.painter.BPLanePainter;
import bp.view.painter.BPShapeFactory;

public class LaneComponent extends BPComponent {

    public static final Integer TEXT_TYPE_REGULAR = 0;
    public static final Integer TEXT_TYPE_ITALIC = 1;

    private String text;
    private Integer textType;
    private final BPLanePainter painter;

    public LaneComponent() {
        painter = new BPLanePainter(this);
        text = "test";
    }

    @Override
    public Integer getDefaultHeight() {
        return 100;
    }

    @Override
    public Integer getDefaultWidth() {
        return 300;
    }

    @Override
    public Integer getMinimumHeight() {
        Integer textWidth = getTextPanelWidth();
        if (textWidth > super.getMinimumHeight())
            return super.getMinimumHeight();
        else
            return textWidth;
    }

    @Override
    public Shape getShape() {
        return BPShapeFactory.lane(this);
    }

    @Override
    protected void initializeElementHandlers() {
        handlers = new ElementHandlers(this, ElementHandlers.RECTANGLE_HANDLERS);

    }

    @Override
    public BasicPainter getPainter() {
        return painter;
    }

    public Integer getTextHeight() {
        return StringUtils.calculateStringHeight(getFont(), text);
    }

    public Integer getTextWidth() {
        return StringUtils.calculateStringWidth(getFont(), text);
    }

    public Integer getTextPanelHeight() {
        return getTextHeight() + 10;
    }

    public Integer getTextPanelWidth() {
        return getTextWidth() + 10;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTextType() {
        return textType;
    }

    public void setTextType(Integer textType) {
        this.textType = textType;
    }
}
