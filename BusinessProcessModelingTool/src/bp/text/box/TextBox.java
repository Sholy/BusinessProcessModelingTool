package bp.text.box;

import bp.model.util.BPKeyWords;

public abstract class TextBox {

    public static final String DEFAULT_INDENTATION = "  ";

    private final BPKeyWords key;
    private Object value;
    private Integer indentationLevel;
    private final TextBox owner;

    public TextBox(final BPKeyWords key) {
        this(key, null, null);
    }

    public TextBox(final BPKeyWords key, final Object value) {
        this(key, value, null);
    }

    public TextBox(final BPKeyWords key, final Object value, final TextBox owner) {
        this.key = key;
        this.value = value;
        this.owner = owner;
        if (this.owner == null) {
            this.indentationLevel = 0;
        } else {
            this.indentationLevel = owner.getIndentationLevel() + 1;
        }

    }

    public abstract String generateText();

    public void textChanged() {
        if (this.owner != null) {
            this.owner.textChanged();
        }
    }

    public String getIndentation() {
        final StringBuilder sb = new StringBuilder();
        for (int i = this.indentationLevel; i > 0; i--) {
            sb.append(DEFAULT_INDENTATION);
        }
        return sb.toString();
    }

    public Integer getIndentationLevel() {
        return this.indentationLevel;
    }

    public void setIndentationLevel(final Integer indentationLevel) {
        if (indentationLevel == null || indentationLevel < 0) {
            this.indentationLevel = 0;
        } else {
            this.indentationLevel = indentationLevel;
        }
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(final Object value) {
        this.value = value;
    }

    public BPKeyWords getKey() {
        return this.key;
    }

    public TextBox getOwner() {
        return this.owner;
    }

}
