package bp.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import bp.details.AbstractDetails;
import bp.gui.BPPanel;
import bp.gui.MainMenu;
import bp.gui.PropertiesView;
import bp.gui.SideToolbar;

public final class AppCore extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6272641537629757811L;
	
	private static AppCore instance;
	
    private MainMenu mainMenu;
    private SideToolbar sideToolbar;
    private PropertiesView propertiesView;
    private JScrollPane propertiesScroll;
    private JPanel rightPanel;
    // private BPGraphicPanel bpPanel;
    private BPPanel bpPanel;


	public static AppCore getInstance() {
		if (instance == null) {
			instance = new AppCore();
		}
		return instance;
	}
	
	private AppCore() {
		initialize();
	}
	
	private void initialize() {
        setSize(new Dimension(1280, 720));
        setMinimumSize(new Dimension(1024, 576));
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        mainMenu = new MainMenu();
        setJMenuBar(mainMenu);

        sideToolbar = new SideToolbar();
        rightPanel = new JPanel(new BorderLayout());
        propertiesView = new PropertiesView();
        propertiesScroll = new JScrollPane(propertiesView);

        initializeView();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

    private void initializeView() {
        setLayout(new BorderLayout());
        JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        splitter.add(propertiesScroll);
        splitter.add(rightPanel);
        splitter.setDividerLocation(270);

        rightPanel.add(sideToolbar, BorderLayout.EAST);

        add(splitter, BorderLayout.CENTER);

        validate();
    }

    public void updateDetails(AbstractDetails details) {
        propertiesView.removeAll();
        propertiesView.add(details);
        propertiesScroll.validate();
        propertiesScroll.repaint();
    }

    public void createBPPanel() {
        if (bpPanel == null) {
            bpPanel = new BPPanel();
            rightPanel.add(bpPanel, BorderLayout.CENTER);
            rightPanel.validate();
        }
    }

    public BPPanel getBpPanel() {
        return bpPanel;
    }
}
