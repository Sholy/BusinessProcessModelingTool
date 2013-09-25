package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.ConditionalStartEvent;
import bp.model.data.Element;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class ConditionalStartEventDetails extends StartEventDetails{

    /**
     * 
     */
    private static final long serialVersionUID = -3830283509661106420L;

    public static final String CONDITION = "Condition:";

    private final ConditionalStartEvent event = (ConditionalStartEvent) getElement();

    private JLabel conditionLb;
    private JTextArea conditionTa;
    private JScrollPane conditionScroll;

    public ConditionalStartEventDetails(final Element element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        this.conditionLb = new JLabel(CONDITION);
        this.conditionTa = new JTextArea(5, 20);
        this.conditionScroll = new JScrollPane(this.conditionTa);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createAdvanced();

        getAdvanced().add(this.conditionLb);
        getAdvanced().add(this.conditionScroll);
    }

    @Override
    protected void addActions() {
        super.addActions();

        this.conditionTa.getDocument().addDocumentListener(new DocumentListener() {

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
                ConditionalStartEventDetails.this.event.updateCondition(
                        ConditionalStartEventDetails.this.conditionTa.getText(), Controller.DETAILS);
            }
        });
    }

    @Override
    protected void dataAttributeChanged(final BPKeyWords keyWord, final Object value) {
        super.dataAttributeChanged(keyWord, value);
        if (value != null) {
            if (keyWord == BPKeyWords.CONDITION) {
                this.conditionTa.setText((String) value);
            }
        }
    }

}
