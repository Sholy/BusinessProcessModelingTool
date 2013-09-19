package bp.model.data;

import java.util.HashSet;
import java.util.Set;

import bp.details.ProcessDetails;

/**
 * Container for business process model
 * 
 * @author Sholy
 * 
 */
public class Process {

    private String uniqueName;
    private String name;
    private String description;
    private String data;

    private final ProcessDetails details;

    private final Set<Element> elements = new HashSet<Element>();

    private Integer blockDefIndentation;

    public Process(String uniqueName, Integer indentation) {
        if (uniqueName == null || uniqueName.trim().isEmpty()) {
            throw new IllegalArgumentException("uniqueName can't be empty or null");
        }
        this.uniqueName = uniqueName;

        if (indentation < 0)
            this.blockDefIndentation = 0;
        else
            this.blockDefIndentation = indentation;
        
        details = new ProcessDetails(this);
        details.updateComponents();
    }

    public Process(String uniqueName) {
        this(uniqueName, 0);
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Set<Element> getElements() {
        return elements;
    }

    public Integer getBlockDefIndentation() {
        return blockDefIndentation;
    }

    public void setBlockDefIndentation(Integer blockDefIndentation) {
        this.blockDefIndentation = blockDefIndentation;
    }

    public Integer getIndentation() {
        return getBlockDefIndentation() + 1;
    }

    public ProcessDetails getDetails() {
        return details;
    }


}
