package bp.model.data;

import bp.details.ElementDetails;
import bp.model.graphic.BPElement;

/**
 * Basic Element of Business Process
 * 
 * @author Sholy
 * 
 */
public abstract class Element {

    private String uniqueName;
    private String name;
    private String description;

    protected ElementDetails details;

    protected BPElement component;

    public Element(String uniqueName) {
        if (uniqueName == null || uniqueName.trim().isEmpty()) {
            throw new IllegalArgumentException("uniqueName can't be empty or null");
        }
        this.uniqueName = uniqueName;
        initializeComponent();
        initializeDetails();
    }

    protected void initializeDetails() {
        // TODO set abstract
    }

    protected void initializeComponent() {
        // TODO set abstract
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ElementDetails getDetails() {
        return details;
    }
    
    public BPElement getComponent() {
        return component;
    }

}
