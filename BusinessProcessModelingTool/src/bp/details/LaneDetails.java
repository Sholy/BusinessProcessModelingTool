package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.Lane;

public class LaneDetails extends ElementDetails{

    /**
     * 
     */
    private static final long serialVersionUID = -5480446616251138679L;

    public static final String PARENT_LABEL = "Parent:";
    public static final String ACTOR_LABEL = "Actor:";

    private final Lane lane = (Lane) getElement();

    private JLabel parentLb;
    private JLabel actorLb;
    private JTextField parentTf;
    private JTextArea actorTa;
    private JScrollPane actorScroll;

    public LaneDetails(Lane lane) {
        super(lane);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        parentLb = new JLabel(PARENT_LABEL);
        actorLb = new JLabel(ACTOR_LABEL);

        parentTf = new JTextField(20);
        actorTa = new JTextArea(5, 20);
        actorScroll = new JScrollPane(actorTa);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createBasic();

        getBasic().add(actorLb);
        getBasic().add(actorScroll);
        getBasic().add(parentLb);
        getBasic().add(parentTf);
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
                // TODO Auto-generated method stub
            }

            private void contentChanged() {
                lane.setActor(actorTa.getText());
            }
        });
    }

    @Override
    public void updateComponents() {
        super.updateComponents();

        updateParent();
        updateActor();
    }

    public void updateParent() {
        if (lane.getParent() != null && lane.getParent().getUniqueName() != null)
            parentTf.setText(lane.getParent().getUniqueName());
    }

    public void updateActor() {
        String laneActor = lane.getActor();
        if (laneActor != null) {
            actorTa.setText(laneActor);
        }
    }

}
