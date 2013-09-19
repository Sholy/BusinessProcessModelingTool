package bp.model.graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

import bp.view.Strokes;

public class BPGraphElement {

    private Color bgColor = Color.WHITE;
    private Color fgColor = Color.BLACK;
    private Font font = new Font("Arial", Font.PLAIN, 12);
    private Stroke bgStroke = Strokes.getLine(Strokes.THIN_LINE);
    private Stroke fgStroke = Strokes.getLine(Strokes.THIN_LINE);

    public BPGraphElement() {

    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public Color getFgColor() {
        return fgColor;
    }

    public void setFgColor(Color fgColor) {
        this.fgColor = fgColor;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Stroke getBgStroke() {
        return bgStroke;
    }

    public void setBgStroke(Stroke bgStroke) {
        this.bgStroke = bgStroke;
    }

    public Stroke getFgStroke() {
        return fgStroke;
    }

    public void setFgStroke(Stroke fgStroke) {
        this.fgStroke = fgStroke;
    }

}
