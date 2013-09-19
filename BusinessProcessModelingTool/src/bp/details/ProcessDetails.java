package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.Process;

public class ProcessDetails extends AbstractDetails {

    /**
     * 
     */
    private static final long serialVersionUID = -8731164849167955775L;

    public static final String UNIQUE_NAME_LABEL = "Unique name:";
    public static final String NAME_LABEL = "Name:";
    public static final String DESCRIPTION_LABEL = "Description:";
    public static final String DATA_LABEL = "Data:";

    private final Process process;

    private JLabel uniqueNameLb;
    private JLabel nameLb;
    private JLabel descriptionLb;
    private JLabel dataLb;
    private JTextField uniqueNameTf;
    private JTextField nameTf;
    private JTextArea descriptionTa;
    private JTextArea dataTa;
    private JScrollPane descriptionScroll;
    private JScrollPane dataScroll;

    public ProcessDetails(Process process) {
        this.process = process;

        initComponents();
        layoutComponents();
        addActions();
    }

    private void initComponents() {
        uniqueNameLb = new JLabel(UNIQUE_NAME_LABEL);
        nameLb = new JLabel(NAME_LABEL);
        descriptionLb = new JLabel(DESCRIPTION_LABEL);
        dataLb = new JLabel(DATA_LABEL);

        uniqueNameTf = new JTextField(20);
        nameTf = new JTextField(20);

        descriptionTa = new JTextArea(5, 20);
        descriptionScroll = new JScrollPane(descriptionTa);
        dataTa = new JTextArea(5, 20);
        dataScroll = new JScrollPane(dataTa);
    }

    private void layoutComponents() {
        createBasic();

        getBasic().add(uniqueNameLb);
        getBasic().add(uniqueNameTf);
        getBasic().add(nameLb);
        getBasic().add(nameTf);
        getBasic().add(descriptionLb);
        getBasic().add(descriptionScroll);

        createAdvanced();

        getAdvanced().add(dataLb);
        getAdvanced().add(dataScroll);
    }

    public void updateComponents() {
        updateUniqueName();
        updateName();
        updateDescription();
        updateData();
    }

    public void updateUniqueName() {
        uniqueNameTf.setText(process.getUniqueName());
    }

    public void updateName() {
        nameTf.setText(process.getName());
    }

    public void updateDescription() {
        descriptionTa.setText(process.getDescription());
    }

    public void updateData() {
        dataTa.setText(process.getData());
    }

    private void addActions() {
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
                // TODO Auto-generated method stub

            }

            private void contentChanged() {
                process.setUniqueName(uniqueNameTf.getText());
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
                // TODO Auto-generated method stub

            }

            private void contentChanged() {
                process.setName(nameTf.getText());
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
                process.setDescription(descriptionTa.getText());
            }
        });

        dataTa.getDocument().addDocumentListener(new DocumentListener() {

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
                process.setData(dataTa.getText());
            }
        });
    }

}
