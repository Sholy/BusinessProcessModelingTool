package bp.details;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.TimerActivityEvent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class TimerActivityEventDetails extends ActivityEventDetails {

    /**
     * 
     */
    private static final long serialVersionUID = -6452307059489329312L;

    public static final String TIME_FORMAT_LABEL = "Time format:";
    public static final String STOP_ACTIVITY_LABEL = "Stop activity:";

    private final TimerActivityEvent event = (TimerActivityEvent) getElement();

    private JLabel timeFormatLb;
    private JLabel stopActivityLb;

    private JTextArea timeFormatTa;
    private JScrollPane timeFormatScroll;
    private JCheckBox stopActivityCb;

    public TimerActivityEventDetails(final TimerActivityEvent element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        this.timeFormatLb = new JLabel(TIME_FORMAT_LABEL);
        this.stopActivityLb = new JLabel(STOP_ACTIVITY_LABEL);

        this.timeFormatTa = new JTextArea(5, 20);
        this.timeFormatScroll = new JScrollPane(this.timeFormatTa);
        this.stopActivityCb = new JCheckBox();
        this.stopActivityCb.setSelected(false);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createAdvanced();

        getAdvanced().add(this.timeFormatLb);
        getAdvanced().add(this.timeFormatScroll);
        getAdvanced().add(this.stopActivityLb);
        getAdvanced().add(this.stopActivityCb);
    }

    @Override
    protected void addActions() {
        super.addActions();

        this.timeFormatTa.getDocument().addDocumentListener(new DocumentListener() {

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
                TimerActivityEventDetails.this.event.updateTimeFormat(
                        TimerActivityEventDetails.this.timeFormatTa.getText(), Controller.DETAILS);
            }
        });

        this.stopActivityCb.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(final ChangeEvent arg0) {
                TimerActivityEventDetails.this.event.updateStopActivity(
                        TimerActivityEventDetails.this.stopActivityCb.isSelected(), Controller.DETAILS);
            }
        });
    }

    @Override
    protected void dataAttributeChanged(final BPKeyWords keyWord, final Object value) {
        super.dataAttributeChanged(keyWord, value);
        if (value != null) {
            if (keyWord == BPKeyWords.TIME_FORMAT) {
                this.timeFormatTa.setText((String) value);
            } else if (keyWord == BPKeyWords.STOP_ACTIVITY) {
                this.stopActivityCb.setSelected((Boolean) value);
            }
        }
    }

}
