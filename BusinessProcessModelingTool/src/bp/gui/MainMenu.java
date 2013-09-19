package bp.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import bp.action.ActionFactory;

public class MainMenu extends JMenuBar{

    /**
     * 
     */
    private static final long serialVersionUID = -9214658978527863760L;

    private JMenu file;

    public MainMenu() {
        initializefileMenu();
    }

    private void initializefileMenu() {
        file = new JMenu();
        file.setMnemonic('f');
        file.setText("File");

        file.add(ActionFactory.getNewDiagram());
        file.addSeparator();
        file.add(ActionFactory.getExit());

        add(file);
    }
}
