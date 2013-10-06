package bp.model.data;

import java.awt.Point;
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

    public Element(final String uniqueName) {
        this.acListeners = new HashSet<>();
        if (uniqueName == null || uniqueName.trim().isEmpty()) {
            throw new IllegalArgumentException("uniqueName can't be empty or null");
        }
        initializeComponent();
        initializeDetails();

        updateUniqueName(uniqueName, null);
    }

    protected abstract void initializeDetails();

    protected abstract void initializeComponent();

    public String getUniqueName() {
        return this.uniqueName;
    }

    public void updateUniqueName(final String uniqueName, final Controller source) {
        this.uniqueName = uniqueName;
        fireAttributeChanged(BPKeyWords.UNIQUE_NAME, this.uniqueName, source);
    }

    public String getName() {
        return this.name;
    }

    public void updateName(final String name, final Controller source) {
        this.name = name;
        fireAttributeChanged(BPKeyWords.NAME, this.name, source);
    }

    public String getDescription() {
        return this.description;
    }

    public void updateDescription(final String description, final Controller source) {
        this.description = description;
        fireAttributeChanged(BPKeyWords.DESCRIPTION, this.description, source);
    }

    public ElementDetails getDetails() {
        return this.details;
    }

    public BPElement getComponent() {
        return this.component;
    }

    public Set<AttributeChangeListener> getAcListeners() {
        return this.acListeners;
    }

    public void addAttributeChangeListener(final AttributeChangeListener listener) {
        this.acListeners.add(listener);
    }

    public void removeAttributeChangeListener(final AttributeChangeListener listener) {
        this.acListeners.remove(listener);
    }

    protected void fireAttributeChanged(final BPKeyWords keyWord, final Object value, final Controller source) {
        for (final AttributeChangeListener listener : this.acListeners) {
            if (source == null || listener.getController() == null || source != listener.getController()) {
                listener.fireAttributeChanged(keyWord, value);
            }
        }
    }

    public boolean isElementAt(final Point p) {
        if (this.component != null) {
            return this.component.getPainter().isElementAt(p);
        }
        return false;
    }

}
