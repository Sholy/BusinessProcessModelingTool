package bp.model.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bp.details.ProcessDetails;
import bp.event.AttributeChangeListener;
import bp.event.ElementsListener;
import bp.model.util.BPKeyWords;
import bp.model.util.Controller;
import bp.util.BPNameGenerator;

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

    private final List<Element> elements = new ArrayList<>();

    private final Set<AttributeChangeListener> acListeners;
    private final Set<ElementsListener> eListeners;

    private final BPNameGenerator nameGenerator;

    public Process(final String uniqueName) {
        this.acListeners = new HashSet<>();
        this.eListeners = new HashSet<>();
        if (uniqueName == null || uniqueName.trim().isEmpty()) {
            throw new IllegalArgumentException("uniqueName can't be empty or null");
        }
        this.uniqueName = uniqueName;

        this.details = new ProcessDetails(this);
        this.nameGenerator = new BPNameGenerator();
    }

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

    public String getData() {
        return this.data;
    }

    public void updateData(final String data, final Controller source) {
        this.data = data;
        fireAttributeChanged(BPKeyWords.DATA, this.data, source);
    }

    public List<Element> getElements() {
        return this.elements;
    }

    public void addElement(final Element e) {
        for (int i = 0; i < this.elements.size(); i++) {
            if (e.getComponent().getzIndex() < this.elements.get(i).getComponent().getzIndex()) {
                this.elements.add(i, e);
                elementAdded(e);
                return;
            }
        }
        this.elements.add(e);
        elementAdded(e);
    }

    public void removeElement(final Element e) {
        final Boolean removed = this.elements.remove(e);
        if (removed) {
            elementRemoved(e);
        }
    }

    public ProcessDetails getDetails() {
        return this.details;
    }

    public BPNameGenerator getNameGenerator() {
        return this.nameGenerator;
    }

    public Set<AttributeChangeListener> getAcListeners() {
        return this.acListeners;
    }

    public void addAttributeChangeListener(final AttributeChangeListener listener) {
        this.acListeners.add(listener);
    }

    protected void fireAttributeChanged(final BPKeyWords keyWord, final Object value, final Controller source) {
        for (final AttributeChangeListener listener : this.acListeners) {
            if (source == null || listener.getController() == null || source != listener.getController()) {
                listener.fireAttributeChanged(keyWord, value);
            }
        }
    }

    public Element getElement(final String uniqueName) {
        for (final Element e : this.elements) {
            if (e.getUniqueName().equals(uniqueName)) {
                return e;
            }
        }
        return null;
    }

    public void addElementsListener(final ElementsListener listener) {
        this.eListeners.add(listener);
    }

    public void removeElementsListener(final ElementsListener listener) {
        this.eListeners.remove(listener);
    }

    protected void elementAdded(final Element e) {
        for (final ElementsListener el : this.eListeners) {
            el.elementAdded(e);
        }
    }

    protected void elementRemoved(final Element e) {
        for (final ElementsListener el : this.eListeners) {
            el.elementRemoved(e);
        }
    }

}
