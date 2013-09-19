package bp.model.data;

public class LinkThrowEvent extends Event {

    private LinkCatchEvent link;

    public LinkThrowEvent(String uniqueName) {
        super(uniqueName);
    }

    @Override
    public boolean canHaveInput() {
        return true;
    }

    @Override
    public boolean canHaveOutput() {
        return false;
    }

    public LinkCatchEvent getLink() {
        return link;
    }

    public void setLink(LinkCatchEvent link) {
        this.link = link;
    }

}
