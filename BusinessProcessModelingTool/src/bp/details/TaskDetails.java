package bp.details;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.Element;
import bp.model.data.ExecutionType;
import bp.model.data.Lane;
import bp.model.data.Task;

public class TaskDetails extends ActivityDetails{

    /**
     * 
     */
    private static final long serialVersionUID = -8344599583920127541L;

    public static final String ACTOR_LABEL = "Actor:";
    public static final String LANE_ACTOR_LABEL = "Actor[Lane]:";
    public static final String AUTO_ASSIGN = "Auto assign:";
    public static final String MULTIPLE_EXECUTION = "Multiple Execution";
    public static final String MULTIPLE_EXECUTION_TYPE = "Multiple Execution Type";

    private final Task task = (Task) getElement();

    private JLabel actorLb;
    private JLabel laneActorLb;
    private JLabel autoAssignLb;
    private JLabel multipleExecutionLb;
    private JLabel multipleExecutionTypeLb;
    private JTextArea actorTa;
    private JScrollPane actorScroll;
    private JTextField laneActorTf;
    private JCheckBox autoAssignCb;
    private JSpinner multipleExecutionSp;
    private JComboBox<String> multipleExecutionTypeCb;

    public TaskDetails(Element element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        actorLb = new JLabel(ACTOR_LABEL);
        laneActorLb = new JLabel(LANE_ACTOR_LABEL);
        autoAssignLb = new JLabel(AUTO_ASSIGN);
        multipleExecutionLb = new JLabel(MULTIPLE_EXECUTION);
        multipleExecutionTypeLb = new JLabel(MULTIPLE_EXECUTION_TYPE);

        actorTa = new JTextArea(5, 20);
        actorScroll = new JScrollPane(actorTa);

        laneActorTf = new JTextField(20);
        laneActorTf.setEnabled(false);

        autoAssignCb = new JCheckBox();

        SpinnerModel sm = new SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1);
        multipleExecutionSp = new JSpinner(sm);

        String[] elements = new String[ExecutionType.values().length];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = ExecutionType.values()[i].getName();
        }
        multipleExecutionTypeCb = new JComboBox<>(elements);
        multipleExecutionTypeCb.setSelectedIndex(0);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createBasic();

        getBasic().add(actorLb);
        getBasic().add(actorScroll);
        getBasic().add(laneActorLb);
        getBasic().add(laneActorTf);

        createAdvanced();

        getAdvanced().add(autoAssignLb);
        getAdvanced().add(autoAssignCb);
        getAdvanced().add(multipleExecutionLb);
        getAdvanced().add(multipleExecutionSp);
        getAdvanced().add(multipleExecutionTypeLb);
        getAdvanced().add(multipleExecutionTypeCb);
    }

    @Override
    protected void addActions() {
        super.addActions();

        actorTa.getDocument().addDocumentListener(new DocumentListener() {

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
                task.setActor(actorTa.getText());
            }
        });

        autoAssignCb.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                task.setAutoAssign(autoAssignCb.isSelected());
            }
        });

        multipleExecutionSp.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                task.setMultipleExecution((Integer) multipleExecutionSp.getValue());
            }
        });

        multipleExecutionTypeCb.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                task.setMultipleExecutionType(ExecutionType.getEnumValue((String) multipleExecutionTypeCb
                        .getSelectedItem()));

            }
        });
    }

    @Override
    public void updateComponents() {
        super.updateComponents();

        updateActor();
        updateLaneActor();
        updateAutoAssign();
        updateMultipleExecution();
        updateMultipleExecutionType();
    }

    public void updateActor() {
        String actor = task.getActor();
        if (actor != null)
            actorTa.setText(actor);
    }

    public void updateLaneActor() {
        Lane lane = task.getLaneActor();
        if (lane != null) {
            String actor = lane.getActor();
            if (actor != null)
                laneActorTf.setText(actor);
        }
    }

    public void updateAutoAssign() {
        Boolean autoAssign = task.getAutoAssign();
        if (autoAssign != null)
            autoAssignCb.setSelected(autoAssign);
    }

    public void updateMultipleExecution() {
        Integer mulExecution = task.getMultipleExecution();
        if (mulExecution != null)
            multipleExecutionSp.setValue(mulExecution);
    }

    public void updateMultipleExecutionType() {
        ExecutionType executionType = task.getMultipleExecutionType();
        if (executionType != null)
            multipleExecutionTypeCb.setSelectedItem(executionType.getName());
    }

}
