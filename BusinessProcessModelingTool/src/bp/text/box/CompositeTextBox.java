package bp.text.box;

import java.util.ArrayList;
import java.util.List;

import bp.model.util.BPKeyWords;

public abstract class CompositeTextBox extends TextBox {

    private final List<TextBox> textBoxes;

    public CompositeTextBox(final BPKeyWords key, final Object value, final TextBox owner) {
        super(key, value, owner);
        this.textBoxes = new ArrayList<>();
    }

    public List<TextBox> getTextBoxes() {
        return this.textBoxes;
    }

    public void appendTextBox(final TextBox textBox) {
        this.textBoxes.add(textBox);
    }

    @Override
    public String generateText() {
        final StringBuilder sb = new StringBuilder();
        for (final TextBox textBox : this.textBoxes) {
            sb.append("\n");
            sb.append(textBox.generateText());
        }
        return sb.toString();
    }

    public AttributeTextBox getAttributeTextBox(final BPKeyWords key) {
        if (key == null)
            return null;

        for (final TextBox textBox : this.textBoxes) {
            if (textBox.getKey() == key && textBox instanceof AttributeTextBox) {
                return (AttributeTextBox) textBox;
            }
        }

        return null;
    }

    public Boolean hasAttributeTextBox(final BPKeyWords key) {
        return getAttributeTextBox(key) != null;
    }

}
