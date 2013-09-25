package bp.action;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.KeyStroke;

import bp.state.StateType;

public class ActionManager {

    private static final Action newDiagram = new NewDiagramAction("New Diagram", "Creates new diagram",
            KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));

    private static final Action exit = new ExitAction("Exit", "Closes Application");
    private static final Action select = new BPAction("Select", "Select Item", StateType.SELECT);

    private static final Action addTask = new BPAction("Task", "Add Task", StateType.TASK);
    private static final Action addUserTask = new BPAction("User Task", "Add User Task", StateType.USER_TASK);
    private static final Action addSystemTask = new BPAction("System Task", "Add System Task", StateType.SYSTEM_TASK);
    private static final Action addLane = new BPAction("Lane", "Add Lane", StateType.LANE);

    private static final Action addEdge = new BPAction("Edge", "Add Edge", StateType.EDGE);
    private static final Action addConditionalEdge = new BPAction("Con. Edge", "Add Conditional Edge", null);
    private static final Action addGateway = new BPAction("Gateway", "Add Gateway", null);

    private static final Action addStartEvent = new BPAction("Normal", "Add Normal Start Event", StateType.START_EVENT);
    private static final Action addTimerStartEvent = new BPAction("Timer", "Add Timer Start Event",
            StateType.TIMER_START_EVENT);
    private static final Action addConditionalStartEvent = new BPAction("Condition", "Add Conditional Start Event",
            StateType.CONDITIONAL_START_EVENT);
    private static final Action addMessageStartEvent = new BPAction("Message", "Add Message Start Event",
            StateType.MESSAGE_START_EVENT);
    private static final Action addSignalStartEvent = new BPAction("Signal", "Add Signal Start Event",
            StateType.SIGNAL_START_EVENT);
    private static final Action addErrorStartEvent = new BPAction("Error", "Add Error Start Event",
            StateType.ERROR_START_EVENT);

    private static final Action addEndEvent = new BPAction("Normal", "Add Normal End Event", null);
    private static final Action addMessageEndEvent = new BPAction("Message", "Add Message End Event", null);
    private static final Action addErrorEndEvent = new BPAction("Error", "Add Error End Event", null);
    private static final Action addSignalEndEvent = new BPAction("Signal", "Add Signal End Event", null);

    private static final Action addCatchTimerEvent = new BPAction("Timer", "Add Catch Timer Intermediate Event", null);
    private static final Action addCatchConditionEvent = new BPAction("Condition",
            "Add Catch Conditional Intermediate Event", null);
    private static final Action addCatchMessageEvent = new BPAction("Message", "Add Catch Message Intermediate Event",
            null);
    private static final Action addCatchSignalEvent = new BPAction("Signal", "Add Catch Signal Intermediate Event",
            null);
    private static final Action addCatchLinkEvent = new BPAction("Link", "Add Catch Link Event", null);

    private static final Action addThrowMessageEvent = new BPAction("Message", "Add Throw Message Intermediate Event",
            null);
    private static final Action addThrowSignalEvent = new BPAction("Signal", "Add Throw Signal Intermediate Event",
            null);
    private static final Action addThrowLinkEvent = new BPAction("Link", "Add Throw Link Event", null);

    private static final Action addActivityMessageEvent = new BPAction("Message", "Add Message Activity Event", null);
    private static final Action addActivityTimerEvent = new BPAction("Timer", "Add Timer Activity Event", null);
    private static final Action addActivityConditionEvent = new BPAction("Condition", "Add Conditional Activity Event",
            null);
    private static final Action addActivitySignalEvent = new BPAction("Signal", "Add Signal Activity Event", null);
    private static final Action addActivityErrorEvent = new BPAction("Error", "Add Error Activity Event", null);

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

    public static Action getAddUserTask() {
        return addUserTask;
    }

    public static Action getAddSystemTask() {
        return addSystemTask;
    }

    public static Action getAddLane() {
        return addLane;
    }

    public static Action getAddEdge() {
        return addEdge;
    }

    public static Action getAddConditionalEdge() {
        return addConditionalEdge;
    }

    public static Action getAddGateway() {
        return addGateway;
    }

    public static Action getAddStartEvent() {
        return addStartEvent;
    }

    public static Action getAddTimerStartEvent() {
        return addTimerStartEvent;
    }

    public static Action getAddConditionalStartEvent() {
        return addConditionalStartEvent;
    }

    public static Action getAddMessageStartEvent() {
        return addMessageStartEvent;
    }

    public static Action getAddSignalStartEvent() {
        return addSignalStartEvent;
    }

    public static Action getAddErrorStartEvent() {
        return addErrorStartEvent;
    }

    public static Action getAddEndEvent() {
        return addEndEvent;
    }

    public static Action getAddMessageEndEvent() {
        return addMessageEndEvent;
    }

    public static Action getAddErrorEndEvent() {
        return addErrorEndEvent;
    }

    public static Action getAddSignalEndEvent() {
        return addSignalEndEvent;
    }

    public static Action getAddCatchTimerEvent() {
        return addCatchTimerEvent;
    }

    public static Action getAddCatchConditionEvent() {
        return addCatchConditionEvent;
    }

    public static Action getAddCatchMessageEvent() {
        return addCatchMessageEvent;
    }

    public static Action getAddCatchSignalEvent() {
        return addCatchSignalEvent;
    }

    public static Action getAddCatchLinkEvent() {
        return addCatchLinkEvent;
    }

    public static Action getAddThrowMessageEvent() {
        return addThrowMessageEvent;
    }

    public static Action getAddThrowSignalEvent() {
        return addThrowSignalEvent;
    }

    public static Action getAddThrowLinkEvent() {
        return addThrowLinkEvent;
    }

    public static Action getAddActivityMessageEvent() {
        return addActivityMessageEvent;
    }

    public static Action getAddActivityTimerEvent() {
        return addActivityTimerEvent;
    }

    public static Action getAddActivityConditionEvent() {
        return addActivityConditionEvent;
    }

    public static Action getAddActivitySignalEvent() {
        return addActivitySignalEvent;
    }

    public static Action getAddActivityErrorEvent() {
        return addActivityErrorEvent;
    }

}
