package bp.state;

import bp.gui.BPPanel;

public class StateManager {

    private final BPPanel panel;

    private State currentState;
    private final State defaultState;

    private final SelectState selectState;
    private final TaskState taskState;
    private final UserTaskState userTaskState;
    private final SystemTaskState systemTaskState;
    private final EdgeState edgeState;
    private final LaneState laneState;
    private final MoveState moveState;
    private final EdgeMoveState moveEdgeState;
    private final ResizeState resizeState;
    private final StartEventState startEventState;
    private final TimerStartEventState timerStartEventState;
    private final ConditionalStartEventState conditionalStartEventState;
    private final MessageStartEventState messageStartEventState;
    private final SignalStartEventState signalStartEventState;
    private final ErrorStartEventState errorStartEventState;

    public StateManager(final BPPanel panel) {
        this.panel = panel;

        this.selectState = new SelectState(panel);
        this.taskState = new TaskState(panel);
        this.userTaskState = new UserTaskState(panel);
        this.systemTaskState = new SystemTaskState(panel);
        this.edgeState = new EdgeState(panel);
        this.laneState = new LaneState(panel);
        this.moveState = new MoveState(panel);
        this.moveEdgeState = new EdgeMoveState(panel);
        this.resizeState = new ResizeState(panel);
        this.startEventState = new StartEventState(panel);
        this.timerStartEventState = new TimerStartEventState(panel);
        this.conditionalStartEventState = new ConditionalStartEventState(panel);
        this.messageStartEventState = new MessageStartEventState(panel);
        this.signalStartEventState = new SignalStartEventState(panel);
        this.errorStartEventState = new ErrorStartEventState(panel);

        this.defaultState = this.selectState;
        this.currentState = this.defaultState;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public void moveToState(final StateType state) {
        // TODO: check if move from current state to next one is possible

        this.currentState.exitingState();

        final State newState = getStateObject(state);
        this.currentState = newState;
        this.currentState.enteringState();
    }

    public BPPanel getPanel() {
        return this.panel;
    }

    private State getStateObject(final StateType stateType) {
        if (stateType == StateType.SELECT)
            return this.selectState;
        else if (stateType == StateType.TASK)
            return this.taskState;
        else if (stateType == StateType.EDGE)
            return this.edgeState;
        else if (stateType == StateType.LANE)
            return this.laneState;
        else if (stateType == StateType.MOVE)
            return this.moveState;
        else if (stateType == StateType.MOVE_EDGE)
            return this.moveEdgeState;
        else if (stateType == StateType.RESIZE)
            return this.resizeState;
        else if (stateType == StateType.USER_TASK)
            return this.userTaskState;
        else if (stateType == StateType.SYSTEM_TASK)
            return this.systemTaskState;
        else if (stateType == StateType.START_EVENT)
            return this.startEventState;
        else if (stateType == StateType.TIMER_START_EVENT)
            return this.timerStartEventState;
        else if (stateType == StateType.CONDITIONAL_START_EVENT)
            return this.conditionalStartEventState;
        else if (stateType == StateType.MESSAGE_START_EVENT)
            return this.messageStartEventState;
        else if (stateType == StateType.SIGNAL_START_EVENT)
            return this.signalStartEventState;
        else if (stateType == StateType.ERROR_START_EVENT)
            return this.errorStartEventState;

        return this.defaultState;
    }
}
