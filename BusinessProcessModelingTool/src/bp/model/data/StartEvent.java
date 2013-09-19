package bp.model.data;

public abstract class StartEvent extends Event {

    public StartEvent(String uniqueName) {
        super(uniqueName);
    }

    @Override
    public boolean canHaveInput() {
        return false;
    }

    @Override
    public boolean canHaveOutput() {
        return true;
    }

}
