package bp.state;

public enum StateType {

    SELECT, 
    TASK, 
    USER_TASK, 
    SYSTEM_TASK, 
    EDGE, 
    LANE, 
    MOVE, 
    MOVE_EDGE, 
    RESIZE, 
    START_EVENT, 
    TIMER_START_EVENT, 
    CONDITIONAL_START_EVENT, 
    MESSAGE_START_EVENT,
    SIGNAL_START_EVENT,
    ERROR_START_EVENT;
}
