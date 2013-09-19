package bp.action;

import java.awt.event.ActionEvent;

import bp.app.AppCore;
import bp.gui.BPPanel;
import bp.state.StateType;

public class AddLane extends BPAction {

    /**
     * 
     */
    private static final long serialVersionUID = -7428238914087830590L;

    public AddLane(String name, String description) {
        super(name, description);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        BPPanel panel = AppCore.getInstance().getBpPanel();
        if (panel != null)
            panel.getStateManager().moveToState(StateType.LANE);
    }

}
