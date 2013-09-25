package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.Element;
import bp.model.data.ErrorStartEvent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class ErrorStartEventDetails extends StartEventDetails{

    /**
     * 
     */
    private static final long serialVersionUID = -7374097101193825991L;

    public static final String ERROR_NAME = "Error name:";

    private final ErrorStartEvent event = (ErrorStartEvent) getElement();

    private JLabel errorNameLb;
    private JTextArea errorNameTa;
    private JScrollPane errorNameScroll;

    public ErrorStartEventDetails(final Element element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        this.errorNameLb = new JLabel(ERROR_NAME);
        this.errorNameTa = new JTextArea(5, 20);
        this.errorNameScroll = new JScrollPane(this.errorNameTa);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createAdvanced();

        getAdvanced().add(this.errorNameLb);
        getAdvanced().add(this.errorNameScroll);
    }

    @Override
    protected void addActions() {
        super.addActions();

        this.errorNameTa.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(final DocumentEvent e) {
                contentChanged();
            }

            @Override
            public void insertUpdate(final DocumentEvent e) {
                contentChanged();
            }

            @Override
            public void changedUpdate(final DocumentEvent e) {

            }

            private void contentChanged() {
                ErrorStartEventDetails.this.event.updateErrorName(ErrorStartEventDetails.this.errorNameTa.getText(),
                        Controller.DETAILS);
            }
        });
    }

    @Override
    protected void dataAttributeChanged(final BPKeyWords keyWord, final Object value) {
        super.dataAttributeChanged(keyWord, value);
        if (value != null) {
            if (keyWord == BPKeyWords.ERROR_NAME) {
                this.errorNameTa.setText((String) value);
            }
        }
    }
}
