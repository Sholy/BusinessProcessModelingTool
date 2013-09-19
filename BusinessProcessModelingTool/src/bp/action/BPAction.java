package bp.action;

import javax.swing.AbstractAction;

public abstract class BPAction extends AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = -5984597151859754940L;

    // private final Image enabledIcon = CursorResource.getCursorResource("action.addCheckBoxes.smallImage");
    // private final Image disabledIcon = CursorResource.getCursorResource("action.denied.smallImage");

    public BPAction() {

    }

    public BPAction(String nameRef) {
        this(nameRef, null);
    }

    public BPAction(String name, String description) {
        if (name != null)
            putValue(NAME, name);

        if (description != null)
            putValue(SHORT_DESCRIPTION, description);
    }

    // public Image getEnabledIcon() {
    // return enabledIcon;
    // }
    //
    // public Image getDisabledIcon() {
    // return disabledIcon;
    // }
}
