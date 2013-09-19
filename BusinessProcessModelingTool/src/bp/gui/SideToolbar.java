package bp.gui;

import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import bp.action.ActionFactory;

public class SideToolbar extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -1021087398755442257L;

    /** common view **/
    private JButton select;

    /** activity view **/
    private JButton task;
    private JButton lane;

    /** flow control view **/
    private JButton edge;

    private JLabel commonLb;
    private JLabel activityLb;
    private JLabel controlFlowLb;

    public SideToolbar() {
        setBorder(new EmptyBorder(10, 10, 10, 10)); // (N, W, S, E)
        LayoutManager layout = new MigLayout("wrap 1", "[fill]", "[]");
        this.setLayout(layout);

        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        select = new JButton(ActionFactory.getSelect());

        task = new JButton(ActionFactory.getAddTask());
        lane = new JButton(ActionFactory.getAddLane());

        edge = new JButton(ActionFactory.getAddEdge());

        commonLb = new JLabel("Common:");
        activityLb = new JLabel("Activity:");
        controlFlowLb = new JLabel("Flow Control:");
    }

    private void layoutComponents() {
        add(commonLb);
        add(select);
        
        add(activityLb);
        add(task);
        add(lane);

        add(controlFlowLb);
        add(edge);
    }

}
