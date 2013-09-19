package bp.model.data;

public abstract class ActivityEvent extends Vertex {

    private Activity activity;

    public ActivityEvent(String uniqueName) {
        super(uniqueName);
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
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
