package bp.details;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.SignalActivityEvent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class SignalActivityEventDetails extends ActivityEventDetails{

    /**
     * 
     */
    private static final long serialVersionUID = 6817615890997648745L;

    public static final String SIGNAL_NAME_LABEL = "Signal name:";
    public static final String DATA_FORMAT_LABEL = "Data format:";
    public static final String STOP_ACTIVITY_LABEL = "Stop activity:";

    private final SignalActivityEvent event = (SignalActivityEvent) getElement();

    private JLabel signalNameLb;
    private JLabel dataFormatLb;
    private JLabel stopActivityLb;

    private JTextField signalNameTf;
    private JTextArea dataFormatTa;
    private JScrollPane dataFormatScroll;
    private JCheckBox stopActivityCb;

    public SignalActivityEventDetails(final SignalActivityEvent element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        this.signalNameLb = new JLabel(SIGNAL_NAME_LABEL);
        this.dataFormatLb = new JLabel(DATA_FORMAT_LABEL);
        this.stopActivityLb = new JLabel(STOP_ACTIVITY_LABEL);

        this.signalNameTf = new JTextField(20);
        this.dataFormatTa = new JTextArea(5, 20);
        this.dataFormatScroll = new JScrollPane(this.dataFormatTa);
        this.stopActivityCb = new JCheckBox();
        this.stopActivityCb.setSelected(false);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createAdvanced();

        getAdvanced().add(this.signalNameLb);
        getAdvanced().add(this.signalNameTf);
        getAdvanced().add(this.dataFormatLb);
        getAdvanced().add(this.dataFormatScroll);
        getAdvanced().add(this.stopActivityLb);
        getAdvanced().add(this.stopActivityCb);
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
                SignalActivityEventDetails.this.event.updateSignalName(
                        SignalActivityEventDetails.this.signalNameTf.getText(), Controller.DETAILS);
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
                SignalActivityEventDetails.this.event.updateDataFormat(
                        SignalActivityEventDetails.this.dataFormatTa.getText(), Controller.DETAILS);
            }
        });

        this.stopActivityCb.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(final ChangeEvent arg0) {
                SignalActivityEventDetails.this.event.updateStopActivity(
                        SignalActivityEventDetails.this.stopActivityCb.isSelected(), Controller.DETAILS);
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
            } else if (keyWord == BPKeyWords.STOP_ACTIVITY) {
                this.stopActivityCb.setSelected((Boolean) value);
            }
        }
    }
}
