package bp.action;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.KeyStroke;

public class ActionFactory {

    private static final Action newDiagram = new NewDiagramAction("New Diagram", "Creates new diagram",
            KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));

    private static final Action exit = new ExitAction("Exit", "Closes Application");
    private static final Action select = new SelectAction("Select", "Select Item");
    private static final Action addTask = new AddTask("Task", "Add Task");
    private static final Action addEdge = new AddEdge("Edge", "Add Edge");
    private static final Action addLane = new AddLane("Lane", "Add Lane");

    public static Action getNewDiagram() {
        return newDiagram;
    }

    public static Action getExit() {
        return exit;
    }

    public static Action getSelect() {
        return select;
    }

    public static Action getAddTask() {
        return addTask;
    }

    public static Action getAddEdge() {
        return addEdge;
    }

    public static Action getAddLane() {
        return addLane;
    }

}
