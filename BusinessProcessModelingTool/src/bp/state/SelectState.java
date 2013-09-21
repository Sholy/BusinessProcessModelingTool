package bp.state;

import java.awt.event.MouseEvent;

import bp.app.AppCore;
import bp.gui.BPPanel;
import bp.model.data.Edge;
import bp.model.data.Element;
import bp.model.data.Lane;
import bp.model.data.Vertex;

public class SelectState extends BPState {

    public SelectState(BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // if handler is clicked don't do anything
        for (Element el : getGraphicPanel().getSelectionManager().getSelectedElements()) {
            if (el.getComponent().getHandlers().isHandlerAt(e.getPoint())) {
                System.out.println("Handler hit");
                return;
            }
        }

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
    public void mouseDragged(MouseEvent e) {
        // check handlers first
        for (Element el : getGraphicPanel().getSelectionManager().getSelectedElements()) {
            if (el.getComponent().getHandlers().isHandlerAt(e.getPoint())) {
                if (el instanceof Edge) {
                    getPanel().getStateManager().moveToState(StateType.MOVE_EDGE);
                } else if (el instanceof Vertex || el instanceof Lane) {
                    getPanel().getStateManager().moveToState(StateType.RESIZE);
                }
            }
        }

        // check elements
        for (Element el : getPanel().getProcess().getElements()) {
            if (el.getComponent().getPainter().isElementAt(e.getPoint())) {
                if (el instanceof Vertex || el instanceof Lane) {
                    getPanel().getStateManager().moveToState(StateType.MOVE);
                }
            }
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
