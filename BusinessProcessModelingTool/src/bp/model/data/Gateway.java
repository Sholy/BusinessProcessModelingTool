package bp.model.data;

public class Gateway extends Vertex {

    private Integer minInput;

    public Integer getMinInput() {
        return minInput;
    }

    public void setMinInput(Integer minInput) {
        this.minInput = minInput;
    }

    public Gateway(String uniqueName) {
        super(uniqueName);
    }

    @Override
    public boolean canHaveInput() {
        return true;
    }

    @Override
    public boolean canHaveOutput() {
        return true;
    }

}
