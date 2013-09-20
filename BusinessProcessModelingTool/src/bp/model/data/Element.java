package bp.model.data;

import java.util.HashSet;
import java.util.Set;

import bp.details.ElementDetails;
import bp.event.AttributeChangeListener;
import bp.model.graphic.BPElement;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;

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

    private final Set<AttributeChangeListener> acListeners;

    public Element(String uniqueName) {
        acListeners = new HashSet<>();
        if (uniqueName == null || uniqueName.trim().isEmpty()) {
            throw new IllegalArgumentException("uniqueName can't be empty or null");
        }
        initializeComponent();
        initializeDetails();

        updateUniqueName(uniqueName, null);
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

    public void updateUniqueName(String uniqueName, Controller source) {
        this.uniqueName = uniqueName;
        fireAttributeChanged(BPKeyWords.UNIQUE_NAME, this.uniqueName, source);
    }

    public String getName() {
        return name;
    }

    public void updateName(String name, Controller source) {
        this.name = name;
        fireAttributeChanged(BPKeyWords.NAME, this.name, source);
    }

    public String getDescription() {
        return description;
    }

    public void updateDescription(String description, Controller source) {
        this.description = description;
        fireAttributeChanged(BPKeyWords.DESCRIPTION, this.description, source);
    }

    public ElementDetails getDetails() {
        return details;
    }
    
    public BPElement getComponent() {
        return component;
    }

    public Set<AttributeChangeListener> getAcListeners() {
        return acListeners;
    }

    public void addAttributeChangeListener(AttributeChangeListener listener) {
        acListeners.add(listener);
    }

    protected void fireAttributeChanged(BPKeyWords keyWord, Object value, Controller source) {
        for (AttributeChangeListener listener : acListeners) {
            if (source == null || listener.getController() == null || source != listener.getController()) {
                listener.fireAttributeChanged(keyWord, value);
            }
        }
    }

}
