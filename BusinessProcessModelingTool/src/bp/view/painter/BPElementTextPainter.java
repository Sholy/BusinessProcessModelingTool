package bp.view.painter;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

import bp.model.graphic.BPComponent;

public class BPElementTextPainter extends BPElementPainter {

    private String text;

    public BPElementTextPainter(final BPComponent component) {
        this(component, null);
    }

    public BPElementTextPainter(final BPComponent component, final String text) {
        super(component);
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    @Override
    public void paint(final Graphics2D g) {
        super.paint(g);

        if (this.text == null || this.text.isEmpty())
            return;

        final Integer textSeparatorSize = 10;
        final BPComponent comp = getComponent();

        g.setFont(comp.getFont());
        g.setPaint(comp.getFgColor());
        final FontMetrics metrics = g.getFontMetrics();
        final Integer stringWidth = metrics.stringWidth(this.text);
        Integer x = comp.getX() + (comp.getWidth() - stringWidth) / 2;
        final Integer y = comp.getY() + comp.getHeight() + metrics.getHeight() + textSeparatorSize;
        if (x < 0)
            x = 0;

        g.drawString(this.text, x, y);


    }

}
