package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.SignalStartEvent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class SignalStartEventDetails extends StartEventDetails{

    /**
     * 
     */
    private static final long serialVersionUID = 9166368454496106012L;

    public static final String DATA_FORMAT = "Data format:";
    public static final String SIGNAL_NAME = "Signal name:";

    private final SignalStartEvent event = (SignalStartEvent) getElement();

    private JLabel dataFormatLb;
    private JLabel signalNameLb;

    private JTextArea dataFormatTa;
    private JScrollPane dataFormatScroll;
    private JTextField signalNameTf;

    public SignalStartEventDetails(final SignalStartEvent element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        this.dataFormatLb = new JLabel(DATA_FORMAT);
        this.signalNameLb = new JLabel(SIGNAL_NAME);

        this.dataFormatTa = new JTextArea(5, 20);
        this.dataFormatScroll = new JScrollPane(this.dataFormatTa);
        this.signalNameTf = new JTextField(20);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createAdvanced();

        getAdvanced().add(this.dataFormatLb);
        getAdvanced().add(this.dataFormatScroll);
        getAdvanced().add(this.signalNameLb);
        getAdvanced().add(this.signalNameTf);
    }

    @Override
    protected void addActions() {
        super.addActions();

        this.dataFormatTa.getDocument().addDocumentListener(new DocumentListener() {

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
                SignalStartEventDetails.this.event.updateDataFormat(
                        SignalStartEventDetails.this.dataFormatTa.getText(), Controller.DETAILS);
            }
        });

        this.signalNameTf.getDocument().addDocumentListener(new DocumentListener() {

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
                SignalStartEventDetails.this.event.updateSignalName(
                        SignalStartEventDetails.this.signalNameTf.getText(), Controller.DETAILS);
            }
        });
    }

    @Override
    protected void dataAttributeChanged(final BPKeyWords keyWord, final Object value) {
        super.dataAttributeChanged(keyWord, value);
        if (value != null) {
            if (keyWord == BPKeyWords.DATA_FORMAT) {
                this.dataFormatTa.setText((String) value);
            } else if (keyWord == BPKeyWords.SIGNAL_NAME) {
                this.signalNameTf.setText((String) value);
            }
        }
    }

}
