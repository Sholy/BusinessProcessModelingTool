package bp.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import bp.app.AppCore;
import bp.model.data.Process;
import bp.state.StateManager;

public class BPPanel extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = 1788034027677048992L;

    private final BPGraphicPanel graphicsPanel;
    private final JScrollPane graphicsScroll;
    private final BPTextPanel text;
    private final JScrollPane textScroll;
    private final JSplitPane splitter;

    private final Process process;
    private final StateManager stateManager;

    public BPPanel() {
        process = new Process("untitledProcess");
        AppCore.getInstance().updateDetails(process.getDetails());

        graphicsPanel = new BPGraphicPanel(this);
        graphicsScroll = new JScrollPane(graphicsPanel);
        text = new BPTextPanel();
        textScroll = new JScrollPane(text);
        splitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        
        stateManager = new StateManager(this);

        initializeView();
    }

    private void initializeView() {
        setLayout(new BorderLayout());

        splitter.add(graphicsScroll);
        splitter.add(textScroll);
        splitter.setDividerLocation(500);
        
        add(splitter, BorderLayout.CENTER);

        validate();
    }

    public BPGraphicPanel getGraphicsPanel() {
        return graphicsPanel;
    }

    public BPTextPanel getText() {
        return text;
    }

    public Process getProcess() {
        return process;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

}
