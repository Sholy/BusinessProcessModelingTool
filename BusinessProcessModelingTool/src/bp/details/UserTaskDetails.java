package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.Element;
import bp.model.data.UserTask;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class UserTaskDetails extends TaskDetails {

    /**
     * 
     */
    private static final long serialVersionUID = -5037434410805225376L;

    public static final String IMPLEMENTATION_LABEL = "Implementation:";

    private final UserTask userTask = (UserTask) getElement();

    private JLabel implementationLb;
    private JTextArea implementationTa;
    private JScrollPane implementationScroll;

    public UserTaskDetails(final Element element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        this.implementationLb = new JLabel(IMPLEMENTATION_LABEL);
        this.implementationTa = new JTextArea(5, 20);
        this.implementationScroll = new JScrollPane(this.implementationTa);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createAdvanced();

        getAdvanced().add(this.implementationLb);
        getAdvanced().add(this.implementationScroll);
    }

    @Override
    protected void addActions() {
        super.addActions();

        this.implementationTa.getDocument().addDocumentListener(new DocumentListener() {

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
                UserTaskDetails.this.userTask.updateImplementation(UserTaskDetails.this.implementationTa.getText(),
                        Controller.DETAILS);
            }
        });
    }

    @Override
    protected void dataAttributeChanged(final BPKeyWords keyWord, final Object value) {
        super.dataAttributeChanged(keyWord, value);
        if (value != null) {
            if (keyWord == BPKeyWords.IMPLEMENTATION) {
                this.implementationTa.setText((String) value);
            }
        }
    }

}
