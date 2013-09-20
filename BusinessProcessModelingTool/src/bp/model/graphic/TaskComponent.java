package bp.model.graphic;

import java.awt.Shape;

import bp.app.AppCore;
import bp.event.AttributeChangeListener;
import bp.model.data.Task;
import bp.model.graphic.util.ElementHandlers;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;
import bp.view.painter.BPElementPainter;
import bp.view.painter.BPElementTextPainter;
import bp.view.painter.BPShapeFactory;

public class TaskComponent extends BPComponent {

    private final BPElementTextPainter painter;
    private String text;
    private final Task task;

    public TaskComponent(Task task) {
        this.task = task;
        this.painter = new BPElementTextPainter(this, text);
        addDataListener();
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

    protected void updateText(String text) {
        this.text = text;
        painter.setText(text);
        AppCore.getInstance().getBpPanel().getGraphicsPanel().repaint();
    }

    protected void addDataListener() {
        task.addAttributeChangeListener(new AttributeChangeListener() {

            @Override
            public Controller getController() {
                return Controller.GRAPHIC;
            }

            @Override
            public void fireAttributeChanged(BPKeyWords keyWord, Object value) {
                if (value != null) {
                    if (keyWord == BPKeyWords.NAME) {
                        updateText((String) value);
                    }
                }
            }
        });
    }

}
