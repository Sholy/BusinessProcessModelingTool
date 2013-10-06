package bp.text.box;

import bp.event.AttributeChangeListener;
import bp.model.data.Process;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class ProcessTextBox extends BlockTextBox {

    private final Process process;

    public ProcessTextBox(final Process process, final TextBox owner) {
        super(BPKeyWords.PROCESS, process.getUniqueName(), 0, owner);
        this.process = process;
        addDataListener();
    }

    protected void dataAttributeChanged(final BPKeyWords keyWord, final Object value) {
        if (value != null) {
            if (keyWord == BPKeyWords.UNIQUE_NAME) {
                setValue(value);
                textChanged();
            } else if (keyWord == BPKeyWords.NAME) {
                final AttributeTextBox attTextBox = getAttributeTextBox(BPKeyWords.NAME);
                if (attTextBox != null) {
                    attTextBox.setValue(value);
                    textChanged();
                } else {
                    appendTextBox(new AttributeTextBox(BPKeyWords.NAME, value, getIndentationLevel() + 1, this));
                    textChanged();
                }
            } else if (keyWord == BPKeyWords.DESCRIPTION) {
                final AttributeTextBox attTextBox = getAttributeTextBox(BPKeyWords.DESCRIPTION);
                if (attTextBox != null) {
                    attTextBox.setValue(value);
                    textChanged();
                } else {
                    appendTextBox(new AttributeTextBox(BPKeyWords.DESCRIPTION, value, getIndentationLevel() + 1, this));
                    textChanged();
                }
            } else if (keyWord == BPKeyWords.DATA) {
                final AttributeTextBox attTextBox = getAttributeTextBox(BPKeyWords.DATA);
                if (attTextBox != null) {
                    attTextBox.setValue(value);
                    textChanged();
                } else {
                    appendTextBox(new AttributeTextBox(BPKeyWords.DATA, value, getIndentationLevel() + 1, this));
                    textChanged();
                }
            }
        }
    }

    private void addDataListener() {
        this.process.addAttributeChangeListener(new AttributeChangeListener() {

            @Override
            public Controller getController() {
                return Controller.TEXT;
            }

            @Override
            public void fireAttributeChanged(final BPKeyWords keyWord, final Object value) {
                dataAttributeChanged(keyWord, value);
            }
        });
    }


}
