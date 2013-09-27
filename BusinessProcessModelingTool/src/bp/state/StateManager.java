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
    private final ConditionalEdgeState conditionalEdgeState;
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
    private final EndEventState endEventState;
    private final MessageEndEventState messageEndEventState;
    private final ErrorEndEventState errorEndEventState;
    private final SignalEndEventState signalEndEventState;
    private final TimerCatchEventState timerCatchEventState;
    private final ConditionalCatchEventState conditionalCatchEventState;
    private final MessageCatchEventState messageCatchEventState;
    private final SignalCatchEventState signalCatchEventState;
    private final LinkCatchEventState linkCatchEventState;
    private final MessageThrowEventState messageThrowEventState;
    private final SignalThrowEventState signalThrowEventState;
    private final LinkThrowEventState linkThrowEventState;
    private final MessageActivityEventState messageActivityEventState;
    private final TimerActivityEventState timerActivityEventState;
    private final ConditionalActivityEventState conditionalActivityEventState;
    private final SignalActivityEventState signalActivityEventState;
    private final ErrorActivityEventState errorActivityEventState;

    public StateManager(final BPPanel panel) {
        this.panel = panel;

        this.selectState = new SelectState(panel);
        this.taskState = new TaskState(panel);
        this.userTaskState = new UserTaskState(panel);
        this.systemTaskState = new SystemTaskState(panel);
        this.edgeState = new EdgeState(panel);
        this.conditionalEdgeState = new ConditionalEdgeState(panel);
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
        this.endEventState = new EndEventState(panel);
        this.messageEndEventState = new MessageEndEventState(panel);
        this.errorEndEventState = new ErrorEndEventState(panel);
        this.signalEndEventState = new SignalEndEventState(panel);
        this.timerCatchEventState = new TimerCatchEventState(panel);
        this.conditionalCatchEventState = new ConditionalCatchEventState(panel);
        this.messageCatchEventState = new MessageCatchEventState(panel);
        this.signalCatchEventState = new SignalCatchEventState(panel);
        this.linkCatchEventState = new LinkCatchEventState(panel);
        this.messageThrowEventState = new MessageThrowEventState(panel);
        this.signalThrowEventState = new SignalThrowEventState(panel);
        this.linkThrowEventState = new LinkThrowEventState(panel);
        this.messageActivityEventState = new MessageActivityEventState(panel);
        this.timerActivityEventState = new TimerActivityEventState(panel);
        this.conditionalActivityEventState = new ConditionalActivityEventState(panel);
        this.signalActivityEventState = new SignalActivityEventState(panel);
        this.errorActivityEventState = new ErrorActivityEventState(panel);

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
        else if (stateType == StateType.CONDITIONAL_EDGE)
            return this.conditionalEdgeState;
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
        else if (stateType == StateType.END_EVENT)
            return this.endEventState;
        else if (stateType == StateType.MESSAGE_END_EVENT)
            return this.messageEndEventState;
        else if (stateType == StateType.ERROR_END_EVENT)
            return this.errorEndEventState;
        else if (stateType == StateType.SIGNAL_END_EVENT)
            return this.signalEndEventState;
        else if (stateType == StateType.TIMER_CATCH_EVENT)
            return this.timerCatchEventState;
        else if (stateType == StateType.CONDITIONAL_CATCH_EVENT)
            return this.conditionalCatchEventState;
        else if (stateType == StateType.MESSAGE_CATCH_EVENT)
            return this.messageCatchEventState;
        else if (stateType == StateType.SIGNAL_CATCH_EVENT)
            return this.signalCatchEventState;
        else if (stateType == StateType.LINK_CATCH_EVENT)
            return this.linkCatchEventState;
        else if (stateType == StateType.MESSAGE_THROW_EVENT)
            return this.messageThrowEventState;
        else if (stateType == StateType.SIGNAL_THROW_EVENT)
            return this.signalThrowEventState;
        else if (stateType == StateType.LINK_THROW_EVENT)
            return this.linkThrowEventState;
        else if (stateType == StateType.MESSAGE_ACTIVITY_EVENT)
            return this.messageActivityEventState;
        else if (stateType == StateType.TIMER_ACTIVITY_EVENT)
            return this.timerActivityEventState;
        else if (stateType == StateType.CONDITIONAL_ACTIVITY_EVENT)
            return this.conditionalActivityEventState;
        else if (stateType == StateType.SIGNAL_ACTIVITY_EVENT)
            return this.signalActivityEventState;
        else if (stateType == StateType.ERROR_ACTIVITY_EVENT)
            return this.errorActivityEventState;

        return this.defaultState;
    }
}
