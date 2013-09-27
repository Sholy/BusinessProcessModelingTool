package bp.model.graphic;

import java.awt.Image;
import java.awt.Shape;

import bp.app.AppCore;
import bp.event.AttributeChangeListener;
import bp.model.data.ActivityEvent;
import bp.model.data.Edge;
import bp.model.data.Task;
import bp.model.graphic.util.ElementHandlers;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;
import bp.util.ImageRes;
import bp.view.painter.BPElementPainter;
import bp.view.painter.BPElementTextPainter;
import bp.view.painter.BPShapeFactory;

public class TaskComponent extends BPComponent implements BPImage {

    private final BPElementTextPainter painter;
    private String text;
    private final Task task;

    private Image image;

    public TaskComponent(final Task task) {
        this(task, null);
    }

    public TaskComponent(final Task task, final ImageRes image) {
        super();
        this.task = task;
        this.painter = new BPElementTextPainter(this, this.text);
        addDataListener();

        if (image != null) {
            this.image = image.getImage();
        }
    }

    @Override
    protected void initializeElementHandlers() {
        this.handlers = new ElementHandlers(this, ElementHandlers.RECTANGLE_HANDLERS);
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
        return this.painter;
    }

    @Override
    public Integer getMinimumWidth() {
        if (this.image == null) {
            return super.getMinimumWidth();
        } else {
            final Integer minImageWidth = getImageWidth() + getImageMargins() * 2;
            if (minImageWidth > super.getMinimumWidth()) {
                return minImageWidth;
            } else {
                return super.getMinimumWidth();
            }
        }
    }

    @Override
    public Integer getMinimumHeight() {
        if (this.image == null) {
            return super.getMinimumHeight();
        } else {
            final Integer minImageHeight = getImageHeight() + getImageMargins() * 2;
            if (minImageHeight > super.getMinimumHeight()) {
                return minImageHeight;
            } else {
                return super.getMinimumHeight();
            }
        }
    }

    public String getText() {
        return this.text;
    }

    protected void updateText(final String text) {
        this.text = text;
        this.painter.setText(text);
        AppCore.getInstance().getBpPanel().getGraphicsPanel().repaint();
    }

    protected void addDataListener() {
        this.task.addAttributeChangeListener(new AttributeChangeListener() {

            @Override
            public Controller getController() {
                return Controller.GRAPHIC;
            }

            @Override
            public void fireAttributeChanged(final BPKeyWords keyWord, final Object value) {
                if (value != null) {
                    if (keyWord == BPKeyWords.NAME) {
                        updateText((String) value);
                    }
                }
            }
        });
    }

    @Override
    public void moveComponent(final Integer diffX, final Integer diffY) {
        if (diffX == null && diffY == null)
            return;

        super.moveComponent(diffX, diffY);

        for (final Edge edge : this.task.getInputEdges()) {
            edge.getEdgeComponent().updateComponent(null, this);
        }
        for (final Edge edge : this.task.getOutputEdges()) {
            edge.getEdgeComponent().updateComponent(this, null);
        }
        for (final ActivityEvent event : this.task.getActivityEvents()) {
            event.getEventComponent().moveComponent(diffX, diffY);
        }
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public Integer getImageWidth() {
        if (this.image != null) {
            return 32;
        }
        return 0;
    }

    @Override
    public Integer getImageHeight() {
        if (this.image != null) {
            return 32;
        }
        return 0;
    }

    @Override
    public Integer getImageMargins() {
        if (this.image != null) {
            return 5;
        }
        return 0;
    }

}
