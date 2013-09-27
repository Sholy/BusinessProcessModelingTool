package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.Element;
import bp.model.data.MessageThrowEvent;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class MessageThrowEventDetails extends IntermediateEventDetails{

    /**
     * 
     */
    private static final long serialVersionUID = 7972577841282926873L;

    public static final String MESSAGE_LABEL = "Message label:";

    private final MessageThrowEvent event = (MessageThrowEvent) getElement();

    private JLabel messageLb;
    private JTextArea messageTa;
    private JScrollPane messageScroll;

    public MessageThrowEventDetails(final Element element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        this.messageLb = new JLabel(MESSAGE_LABEL);
        this.messageTa = new JTextArea(5, 20);
        this.messageScroll = new JScrollPane(this.messageTa);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createAdvanced();

        getAdvanced().add(this.messageLb);
        getAdvanced().add(this.messageScroll);
    }

    @Override
    protected void addActions() {
        super.addActions();

        this.messageTa.getDocument().addDocumentListener(new DocumentListener() {

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
                MessageThrowEventDetails.this.event.updateMessage(MessageThrowEventDetails.this.messageTa.getText(),
                        Controller.DETAILS);
            }
        });
    }

    @Override
    protected void dataAttributeChanged(final BPKeyWords keyWord, final Object value) {
        super.dataAttributeChanged(keyWord, value);
        if (value != null) {
            if (keyWord == BPKeyWords.MESSAGE) {
                this.messageTa.setText((String) value);
            }
        }
    }

}
