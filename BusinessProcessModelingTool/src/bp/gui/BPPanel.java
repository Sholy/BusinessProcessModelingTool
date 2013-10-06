package bp.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import bp.app.AppCore;
import bp.model.data.Process;
import bp.state.StateManager;
import bp.text.box.RootTextBox;

public class BPPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1788034027677048992L;

    private final BPGraphicPanel graphicsPanel;
    private final JScrollPane graphicsScroll;
    private final BPTextPanel text;
    private final JScrollPane textScroll;
    private final JSplitPane splitter;

    private final RootTextBox textBox;
    private final Process process;
    private final StateManager stateManager;

    public BPPanel() {
        this.process = new Process("untitledProcess");
        AppCore.getInstance().updateDetails(this.process.getDetails());

        this.textBox = new RootTextBox(this.process);
        this.text = new BPTextPanel(this.textBox);

        this.graphicsPanel = new BPGraphicPanel(this);
        this.graphicsScroll = new JScrollPane(this.graphicsPanel);
        this.textScroll = new JScrollPane(this.text);
        this.splitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        this.stateManager = new StateManager(this);

        initializeView();
    }

    private void initializeView() {
        setLayout(new BorderLayout());

        this.splitter.add(this.graphicsScroll);
        this.splitter.add(this.textScroll);
        this.splitter.setDividerLocation(500);

        add(this.splitter, BorderLayout.CENTER);

        validate();
    }

    public BPGraphicPanel getGraphicsPanel() {
        return this.graphicsPanel;
    }

    public BPTextPanel getText() {
        return this.text;
    }

    public Process getProcess() {
        return this.process;
    }

    public StateManager getStateManager() {
        return this.stateManager;
    }

}
