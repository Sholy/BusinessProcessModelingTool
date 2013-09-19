package bp.state;

import java.awt.event.MouseEvent;

import bp.app.AppCore;
import bp.gui.BPPanel;
import bp.model.data.Element;

public class SelectState extends BPState {

    public SelectState(BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Boolean elementHit = false;
        for (Element el : getPanel().getProcess().getElements()) {
            if (el.getComponent().getPainter().isElementAt(e.getPoint())) {
                elementHit = true;
                System.out.println("Element hit");
                if (!getGraphicPanel().getSelectionManager().isElementSelected(el)) {
                    getGraphicPanel().getSelectionManager().clearSelection();
                    getGraphicPanel().getSelectionManager().addToSelection(el);
                    getGraphicPanel().repaint();
                    AppCore.getInstance().updateDetails(el.getDetails());
                }
                break;
            }
        } 

        if (!elementHit) {
            getGraphicPanel().getSelectionManager().clearSelection();
            getGraphicPanel().repaint();
            AppCore.getInstance().updateDetails(getPanel().getProcess().getDetails());
        }
    }

    @Override
    public void enteringState() {
        System.out.println("entering select state");

    }

    @Override
    public void exitingState() {
        System.out.println("exiting select state");
    }
}
