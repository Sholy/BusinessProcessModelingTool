package bp.model.data;

public class SubProcess extends Activity {

    private Process process;

    public SubProcess(String uniqueName) {
        super(uniqueName);
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

}
