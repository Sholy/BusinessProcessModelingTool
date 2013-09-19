package bp.action;

import java.awt.event.ActionEvent;

import bp.app.AppCore;
import bp.gui.BPPanel;
import bp.state.StateType;

public class AddEdge extends BPAction {

    /**
     * 
     */
    private static final long serialVersionUID = 715296487313784183L;

    public AddEdge(String name, String description) {
        super(name, description);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BPPanel panel = AppCore.getInstance().getBpPanel();
        if (panel != null) {
            panel.getStateManager().moveToState(StateType.EDGE);
        }
    }

}
