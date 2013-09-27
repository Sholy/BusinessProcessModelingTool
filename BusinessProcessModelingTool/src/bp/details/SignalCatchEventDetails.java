package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.Element;
import bp.model.data.SignalCatchEvent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class SignalCatchEventDetails extends IntermediateEventDetails{

    /**
     * 
     */
    private static final long serialVersionUID = -671378795026308653L;

    public static final String SIGNAL_NAME = "Signal name:";
    public static final String DATA_FORMAT = "Data format:";

    private final SignalCatchEvent event = (SignalCatchEvent) getElement();

    private JLabel signalNameLb;
    private JLabel dataFormatLb;

    private JTextField signalNameTf;
    private JTextArea dataFormatTa;
    private JScrollPane dataFormatScroll;

    public SignalCatchEventDetails(final Element element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        this.signalNameLb = new JLabel(SIGNAL_NAME);
        this.dataFormatLb = new JLabel(DATA_FORMAT);

        this.signalNameTf = new JTextField(20);
        this.dataFormatTa = new JTextArea(5, 20);
        this.dataFormatScroll = new JScrollPane(this.dataFormatTa);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createAdvanced();

        getAdvanced().add(this.signalNameLb);
        getAdvanced().add(this.signalNameTf);
        getAdvanced().add(this.dataFormatLb);
        getAdvanced().add(this.dataFormatScroll);
    }

    @Override
    protected void addActions() {
        super.addActions();

        this.signalNameTf.getDocument().addDocumentListener(new DocumentListener() {

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
                SignalCatchEventDetails.this.event.updateSignalName(
                        SignalCatchEventDetails.this.signalNameTf.getText(), Controller.DETAILS);
            }
        });

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
                SignalCatchEventDetails.this.event.updateDataFormat(
                        SignalCatchEventDetails.this.dataFormatTa.getText(), Controller.DETAILS);
            }
        });
    }

    @Override
    protected void dataAttributeChanged(final BPKeyWords keyWord, final Object value) {
        super.dataAttributeChanged(keyWord, value);
        if (value != null) {
            if (keyWord == BPKeyWords.SIGNAL_NAME) {
                this.signalNameTf.setText((String) value);
            } else if (keyWord == BPKeyWords.DATA_FORMAT) {
                this.dataFormatTa.setText((String) value);
            }
        }
    }

}
