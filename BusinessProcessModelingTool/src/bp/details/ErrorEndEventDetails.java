package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.ErrorEndEvent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class ErrorEndEventDetails extends EndEventDetails{

    /**
     * 
     */
    private static final long serialVersionUID = 5055646866954258546L;

    public static final String ERROR_NAME_LABEL = "Error name:";
    public static final String ERROR_DATA_LABEL = "Error data:";

    private final ErrorEndEvent event = (ErrorEndEvent) getElement();

    private JLabel errorNameLb;
    private JLabel errorDataLb;

    private JTextField errorNameTf;
    private JTextArea errorDataTa;
    private JScrollPane errorDataScroll;

    public ErrorEndEventDetails(final ErrorEndEvent element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        this.errorNameLb = new JLabel(ERROR_NAME_LABEL);
        this.errorDataLb = new JLabel(ERROR_DATA_LABEL);

        this.errorNameTf = new JTextField(20);

        this.errorDataTa = new JTextArea(5, 20);
        this.errorDataScroll = new JScrollPane(this.errorDataTa);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createAdvanced();

        getAdvanced().add(this.errorNameLb);
        getAdvanced().add(this.errorNameTf);
        getAdvanced().add(this.errorDataLb);
        getAdvanced().add(this.errorDataScroll);
    }

    @Override
    protected void addActions() {
        super.addActions();

        this.errorNameTf.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(final DocumentEvent arg0) {
                contentChanged();
            }

            @Override
            public void insertUpdate(final DocumentEvent arg0) {
                contentChanged();
            }

            @Override
            public void changedUpdate(final DocumentEvent arg0) {

            }

            private void contentChanged() {
                ErrorEndEventDetails.this.event.updateErrorName(ErrorEndEventDetails.this.errorNameTf.getText(),
                        Controller.DETAILS);
            }
        });

        this.errorDataTa.getDocument().addDocumentListener(new DocumentListener() {

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
                ErrorEndEventDetails.this.event.updateErrorData(ErrorEndEventDetails.this.errorDataTa.getText(),
                        Controller.DETAILS);
            }
        });
    }

    @Override
    protected void dataAttributeChanged(final BPKeyWords keyWord, final Object value) {
        super.dataAttributeChanged(keyWord, value);
        if (value != null) {
            if (keyWord == BPKeyWords.ERROR_NAME) {
                this.errorNameTf.setText((String) value);
            } else if (keyWord == BPKeyWords.ERROR_DATA) {
                this.errorDataTa.setText((String) value);
            }
        }
    }

}
