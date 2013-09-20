package bp.model.util;


public enum BPKeyWords {

    PROCESS("process"),
    NAME("name"),
    DESCRIPTION("description"),
    DATA("data"),
    TASK("task"),
    ACTOR("actor"),
    LANE_ACTOR("actor[lane]"),
    MIN_INPUT("minInput"),
    AUTO_ASSIGN("autoAssign"),
    MULTIPLE_EXECUTION("multipleExecution"),
    MULTIPLE_EXECUTION_TYPE("multipleExecutionType"),
    LOOP_EXPRESSION("loopExpression"),
    USER_TASK("userTask"),
    IMPLEMENTATION("implementation"),
    SYSTEM_TASK("systemTask"),
    EDGE("edge"),
    SOURCE("source"),
    TARGET("target"),
    CONDITIONAL_EDGE("conditionalEdge"),
    CONDITION("condition"),
    GATEWAY("gateway"),
    LANE("lane"),
    PARENT("parent"),
    START("start"),
    SIGNAL_START("signalStart"),
    SIGNAL_NAME("signalName"),
    DATA_FORMAT("dataFormat"),
    MESSAGE_START("messageStart"),
    TIMER_START("timerStart"),
    TIME_FORMAT("timeFormat"),
    CONDITIONAL_START("conditionalStart"),
    ERROR_START("errorStart"),
    ERROR_NAME("errorName"),
    MULTIPLE_START("multipleStart"),
    END("end"),
    MESSAGE_END("messageEnd"),
    MAX_TRIGGERS("maxTriggers"),
    MESSAGE("message"),
    SIGNAL_END("signalEnd"),
    SIGNAL_DATA("signalData"),
    ERROR_END("errorEnd"),
    ERROR_DATA("errorData"),
    MULTIPLE_END("multipleEnd"),
    TIMER_CATCH_EVENT("timerCatchEvennt"),
    CONDITIONAL_CATCH_EVENT("conditionalCatchEvent"),
    MESSAGE_CATCH_EVENT("messageCatchEvent"),
    SIGNAL_CATCH_EVENT("signalCatchEvent"),
    MESSAGE_THROW_EVENT("messageThrowEvent"),
    SIGNAL_THROW_EVENT("signalThrowEvent"),
    LINK_CATCH_EVENT("linkCatchEvent"),
    LINK_THROW_EVENT("linkThrowEvent"),
    LINK("link"),
    MESSAGE_ACTIVITY_EVENT("messageActivityEvent"),
    STOP_ACTIVITY("stopActivity"),
    SIGNAL_ACTIVITY_EVENT("signalActivityEvent"),
    TIMER_ACTIVITY_EVENT("timerActivityEvent"),
    CONDITIONAL_ACTIVITY_EVENT("conditionalActivityEvent"),
    ERROR_ACTIVITY_EVENT("errorActivityEvent"),
    SUBPROCESS("subProcess"),
    TRUE("true"),
    FALSE("false"),
    PARALLEL("parallel"),
    SEQUENTIAL("sequential"),
    UNIQUE_NAME("");
    
    
    private String name;
    
    private BPKeyWords(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

}
