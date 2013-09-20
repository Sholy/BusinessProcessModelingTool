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

public abstract class ElementDetails extends AbstractDetails {

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

    public ElementDetails(Element element) {
        this.element = element;

        initComponents();
        layoutComponents();
        addActions();
        addDataListener();
    }

    protected void initComponents() {
        uniqueNameLb = new JLabel(UNIQUE_NAME_LABEL);
        nameLb = new JLabel(NAME_LABEL);
        descriptionLb = new JLabel(DESCRIPTION_LABEL);

        uniqueNameTf = new JTextField(20);
        nameTf = new JTextField(20);

        descriptionTa = new JTextArea(5, 20);
        descriptionScroll = new JScrollPane(descriptionTa);
    }
    
    protected void layoutComponents() {
        createBasic();

        getBasic().add(uniqueNameLb);
        getBasic().add(uniqueNameTf);
        getBasic().add(nameLb);
        getBasic().add(nameTf);
        getBasic().add(descriptionLb);
        getBasic().add(descriptionScroll);
    }

    protected void addActions() {
        uniqueNameTf.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                contentChanged();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                contentChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            private void contentChanged() {
                getElement().updateUniqueName(uniqueNameTf.getText(), Controller.DETAILS);
            }
        });

        nameTf.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                contentChanged();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                contentChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            private void contentChanged() {
                getElement().updateName(nameTf.getText(), Controller.DETAILS);
            }
        });

        descriptionTa.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                contentChanged();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                contentChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            private void contentChanged() {
                getElement().updateDescription(descriptionTa.getText(), Controller.DETAILS);
            }
        });
    }

    protected void dataAttributeChanged(BPKeyWords keyWord, Object value) {
        if (value != null) {
            if (keyWord == BPKeyWords.UNIQUE_NAME) {
                uniqueNameTf.setText((String) value);
            } else if (keyWord == BPKeyWords.NAME) {
                nameTf.setText((String) value);
            } else if (keyWord == BPKeyWords.DESCRIPTION) {
                descriptionTa.setText((String) value);
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
            public void fireAttributeChanged(BPKeyWords keyWord, Object value) {
                dataAttributeChanged(keyWord, value);
            }
        });
    }

    protected Element getElement() {
        return element;
    }

}
