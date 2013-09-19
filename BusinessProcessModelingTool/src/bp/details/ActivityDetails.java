package bp.details;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import bp.model.data.Activity;
import bp.model.data.Element;

public abstract class ActivityDetails extends ElementDetails{

    /**
     * 
     */
    private static final long serialVersionUID = 8765453750320541702L;

    public static final String DATA_LABEL = "Data:";
    public static final String LOOP_EXPRESSION_LABEL = "Loop expression:";
    public static final String MIN_INPUT_LABEL = "Minimal input count:";

    private final Activity activity = (Activity) getElement();

    private JLabel dataLb;
    private JLabel loopExpressionLb;
    private JLabel minInputLb;
    private JTextArea dataTa;
    private JTextArea loopExpressionTa;
    private JScrollPane dataScroll;
    private JScrollPane loopExpressionScroll;
    private JSpinner minInputSp;

    public ActivityDetails(Element element) {
        super(element);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        dataLb = new JLabel(DATA_LABEL);
        loopExpressionLb = new JLabel(LOOP_EXPRESSION_LABEL);
        minInputLb = new JLabel(MIN_INPUT_LABEL);

        dataTa = new JTextArea(5, 20);
        loopExpressionTa = new JTextArea(5, 20);

        dataScroll = new JScrollPane(dataTa);
        loopExpressionScroll = new JScrollPane(loopExpressionTa);

        SpinnerModel sm = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        minInputSp = new JSpinner(sm);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createAdvanced();

        getAdvanced().add(dataLb);
        getAdvanced().add(dataScroll);
        getAdvanced().add(loopExpressionLb);
        getAdvanced().add(loopExpressionScroll);
        getAdvanced().add(minInputLb);
        getAdvanced().add(minInputSp);
    }

    @Override
    protected void addActions() {
        super.addActions();

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
                activity.setData(dataTa.getText());
            }
        });

        loopExpressionTa.getDocument().addDocumentListener(new DocumentListener() {

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
                activity.setLoopExpression(loopExpressionTa.getText());
            }
        });

        minInputSp.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                activity.setMinInput((Integer) minInputSp.getValue());
            }
        });
    }

    @Override
    public void updateComponents() {
        super.updateComponents();

        updateData();
        updateLoopExpression();
        updateMinInput();
    }

    public void updateData() {
        String data = activity.getData();
        if (data != null)
            dataTa.setText(data);
    }

    public void updateLoopExpression() {
        String loopExpression = activity.getLoopExpression();
        if (loopExpression != null)
            loopExpressionTa.setText(loopExpression);
    }

    public void updateMinInput() {
        Integer minInput = activity.getMinInput();
        if (minInput != null)
            minInputSp.setValue(minInput);
    }

}
