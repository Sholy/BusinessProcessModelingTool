package bp.app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {

    public static void main(final String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        AppCore.getInstance();
    }
}
