package bp.model.graphic;

import java.awt.Shape;

import bp.model.graphic.util.ElementHandlers;
import bp.view.painter.BPElementPainter;
import bp.view.painter.BPElementTextPainter;
import bp.view.painter.BPShapeFactory;

public class TaskComponent extends BPComponent {

    private BPElementTextPainter painter;
    private String text;

    public TaskComponent() {
        painter = new BPElementTextPainter(this, text);
    }

    @Override
    protected void initializeElementHandlers() {
        handlers = new ElementHandlers(this, ElementHandlers.RECTANGLE_HANDLERS);
    }

    @Override
    public Integer getDefaultHeight() {
        return 50;
    }

    @Override
    public Integer getDefaultWidth() {
        return 150;
    }

    @Override
    public Shape getShape() {
        return BPShapeFactory.task(this);
    }

    @Override
    public BPElementPainter getPainter() {
        return painter;
    }

    public String getText() {
        return text;
    }

    public void updateText(String text) {
        this.text = text;
        painter.setText(text);
    }
}
