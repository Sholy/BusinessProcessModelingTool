package bp.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import bp.model.data.Element;
import bp.model.data.Process;
import bp.model.graphic.util.SelectionManager;

/**
 * Canvas for drawing
 * @author Sholy
 *
 */
public class BPGraphicPanel extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = 1788034027677048992L;

    private final BPPanel mainPanel;
    private final SelectionManager selectionManager;
    
    private final Process process;

    public BPGraphicPanel(BPPanel mainPanel) {
        setBackground(Color.WHITE);
        this.selectionManager = new SelectionManager();
        this.mainPanel = mainPanel;
        this.process = mainPanel.getProcess();

        initializeMouseController();
    }

    private void initializeMouseController() {
        MouseController controller = new MouseController(mainPanel);
        this.addMouseListener(controller);
        this.addMouseMotionListener(controller);
    }

    public SelectionManager getSelectionManager() {
        return selectionManager;
    }

    public BPPanel getMainPanel() {
        return mainPanel;
    }

    public boolean isElementAt(Point p) {
        for (Element e : process.getElements()) {
            if (e.getComponent().getPainter().isElementAt(p))
                return true;
        }
        return false;
    }

    public Element getElementAt(Point p) {
        for (Element e : process.getElements()) {
            if (e.getComponent().getPainter().isElementAt(p))
                return e;
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Element e : process.getElements()) {
            e.getComponent().getPainter().paint(g2);
        }

        for (Element e : process.getElements()) {
            if (getSelectionManager().isElementSelected(e)) {
                e.getComponent().getPainter().paintHandlers(g2);
            }
        }
    }

}
