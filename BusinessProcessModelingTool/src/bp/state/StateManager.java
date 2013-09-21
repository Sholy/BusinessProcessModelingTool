package bp.state;

import bp.gui.BPPanel;

public class StateManager {

    private final BPPanel panel;

    private State currentState;
    private final State defaultState;

    private final SelectState selectState;
    private final TaskState taskState;
    private final EdgeState edgeState;
    private final LaneState laneState;
    private final MoveState moveState;
    private final EdgeMoveState moveEdgeState;
    private final ResizeState resizeState;

    public StateManager(BPPanel panel) {
        this.panel = panel;

        selectState = new SelectState(panel);
        taskState = new TaskState(panel);
        edgeState = new EdgeState(panel);
        laneState = new LaneState(panel);
        moveState = new MoveState(panel);
        moveEdgeState = new EdgeMoveState(panel);
        resizeState = new ResizeState(panel);

        defaultState = selectState;
        currentState = defaultState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void moveToState(StateType state) {
        // TODO: check if move from current state to next one is possible

        currentState.exitingState();

        State newState = getStateObject(state);
        currentState = newState;
        currentState.enteringState();
    }

    public BPPanel getPanel() {
        return panel;
    }

    private State getStateObject(StateType stateType) {
        if (stateType == StateType.SELECT)
            return selectState;
        else if (stateType == StateType.TASK)
            return taskState;
        else if (stateType == StateType.EDGE)
            return edgeState;
        else if (stateType == StateType.LANE)
            return laneState;
        else if (stateType == StateType.MOVE)
            return moveState;
        else if (stateType == StateType.MOVE_EDGE)
            return moveEdgeState;
        else if (stateType == StateType.RESIZE)
            return resizeState;

        return defaultState;
    }
}
