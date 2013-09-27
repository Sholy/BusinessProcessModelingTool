package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.event.AttributeChangeListener;
import bp.model.data.Element;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

public class ElementDetails extends AbstractDetails {

    /**
     * 
     */
    private static final long serialVersionUID = -7999313490510402309L;

    public static final String UNIQUE_NAME_LABEL = "Unique name:";
    public static final String NAME_LABEL = "Name:";
    public static final String DESCRIPTION_LABEL = "Description:";

    private final Element element;

    private JLabel uniqueNameLb;
    private JLabel nameLb;
    private JLabel descriptionLb;
    private JTextField uniqueNameTf;
    private JTextField nameTf;
    private JTextArea descriptionTa;
    private JScrollPane descriptionScroll;

    public ElementDetails(final Element element) {
        this.element = element;

        initComponents();
        layoutComponents();
        addActions();
        addDataListener();
    }

    protected void initComponents() {
        this.uniqueNameLb = new JLabel(UNIQUE_NAME_LABEL);
        this.nameLb = new JLabel(NAME_LABEL);
        this.descriptionLb = new JLabel(DESCRIPTION_LABEL);

        this.uniqueNameTf = new JTextField(20);
        this.nameTf = new JTextField(20);

        this.descriptionTa = new JTextArea(5, 20);
        this.descriptionScroll = new JScrollPane(this.descriptionTa);
    }

    protected void layoutComponents() {
        createBasic();

        getBasic().add(this.uniqueNameLb);
        getBasic().add(this.uniqueNameTf);
        getBasic().add(this.nameLb);
        getBasic().add(this.nameTf);
        getBasic().add(this.descriptionLb);
        getBasic().add(this.descriptionScroll);
    }

    protected void addActions() {
        this.uniqueNameTf.getDocument().addDocumentListener(new DocumentListener() {

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
                getElement().updateUniqueName(ElementDetails.this.uniqueNameTf.getText(), Controller.DETAILS);
            }
        });

        this.nameTf.getDocument().addDocumentListener(new DocumentListener() {

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
                getElement().updateName(ElementDetails.this.nameTf.getText(), Controller.DETAILS);
            }
        });

        this.descriptionTa.getDocument().addDocumentListener(new DocumentListener() {

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
                getElement().updateDescription(ElementDetails.this.descriptionTa.getText(), Controller.DETAILS);
            }
        });
    }

    protected void dataAttributeChanged(final BPKeyWords keyWord, final Object value) {
        if (value != null) {
            if (keyWord == BPKeyWords.UNIQUE_NAME) {
                this.uniqueNameTf.setText((String) value);
            } else if (keyWord == BPKeyWords.NAME) {
                this.nameTf.setText((String) value);
            } else if (keyWord == BPKeyWords.DESCRIPTION) {
                this.descriptionTa.setText((String) value);
            }
        }
    }

    private void addDataListener() {
        getElement().addAttributeChangeListener(new AttributeChangeListener() {

            @Override
            public Controller getController() {
                return Controller.DETAILS;
            }

            @Override
            public void fireAttributeChanged(final BPKeyWords keyWord, final Object value) {
                dataAttributeChanged(keyWord, value);
            }
        });
    }

    protected Element getElement() {
        return this.element;
    }

}
