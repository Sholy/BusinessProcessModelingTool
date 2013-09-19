package bp.model.data;

public class LinkCatchEvent extends Event {

    public LinkCatchEvent(String uniqueName) {
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
