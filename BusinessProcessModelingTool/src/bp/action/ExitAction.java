package bp.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class ExitAction extends AbstractAction{

    /**
     * 
     */
    private static final long serialVersionUID = -3235833466723101089L;

    public ExitAction(String name, String description) {
        putValue(Action.NAME, name);
        putValue(Action.SHORT_DESCRIPTION, description);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.exit(0);

    }

}
