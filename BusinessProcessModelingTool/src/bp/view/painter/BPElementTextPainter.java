package bp.view.painter;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

import bp.model.graphic.BPComponent;

public class BPElementTextPainter extends BPElementPainter {

    private String text;

    public BPElementTextPainter(BPComponent component, String text) {
        super(component);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);

        if (text == null || text.isEmpty())
            return;

        final Integer textSeparatorSize = 10;
        final BPComponent comp = getComponent();

        g.setFont(comp.getFont());
        g.setPaint(comp.getFgColor());
        FontMetrics metrics = g.getFontMetrics();
        Integer stringWidth = metrics.stringWidth(text);
        Integer x = comp.getX() + (comp.getWidth() - stringWidth) / 2;
        Integer y = comp.getY() + comp.getHeight() + metrics.getHeight() + textSeparatorSize;
        if (x < 0)
            x = 0;

        g.drawString(text, x, y);


    }

}
