package bp.details;

import javax.swing.JLabel;
import javax.swing.JTextField;

import bp.model.data.Edge;
import bp.model.util.BPKeyWords;

public class EdgeDetails extends ElementDetails {

    /**
     * 
     */
    private static final long serialVersionUID = -4876745930351443176L;

    public static final String TARGET_LABEL = "Target:";
    public static final String SOURCE_LABEL = "Source:";

    private final Edge edge = (Edge) getElement();

    private JLabel targetLb;
    private JLabel sourceLb;
    private JTextField targetTf;
    private JTextField sourceTf;

    public EdgeDetails(Edge edge) {
        super(edge);
    }

    @Override
    protected void initComponents() {
        super.initComponents();

        targetLb = new JLabel(TARGET_LABEL);
        sourceLb = new JLabel(SOURCE_LABEL);

        targetTf = new JTextField(20);
        sourceTf = new JTextField(20);

        targetTf.setEnabled(false);
        sourceTf.setEnabled(false);
    }

    @Override
    protected void layoutComponents() {
        super.layoutComponents();

        createBasic();

        getBasic().add(targetLb);
        getBasic().add(targetTf);
        getBasic().add(sourceLb);
        getBasic().add(sourceTf);
    }

    @Override
    protected void dataAttributeChanged(BPKeyWords keyWord, Object value) {
        super.dataAttributeChanged(keyWord, value);
        if (value != null) {
            if (keyWord == BPKeyWords.SOURCE) {
                // TODO
            } else if (keyWord == BPKeyWords.TARGET) {
                // TODO
            }
        }
    }
    
}
