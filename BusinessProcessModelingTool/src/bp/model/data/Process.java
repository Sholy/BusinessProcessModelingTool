package bp.model.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bp.details.ProcessDetails;
import bp.event.AttributeChangeListener;
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

    private final BPNameGenerator nameGenerator;

    private Integer blockDefIndentation;

    public Process(final String uniqueName, final Integer indentation) {
        this.acListeners = new HashSet<>();
        if (uniqueName == null || uniqueName.trim().isEmpty()) {
            throw new IllegalArgumentException("uniqueName can't be empty or null");
        }
        this.uniqueName = uniqueName;

        if (indentation < 0)
            this.blockDefIndentation = 0;
        else
            this.blockDefIndentation = indentation;

        this.details = new ProcessDetails(this);
        this.nameGenerator = new BPNameGenerator();
    }

    public Process(final String uniqueName) {
        this(uniqueName, 0);
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
                return;
            }
        }
        this.elements.add(e);
    }

    public Integer getBlockDefIndentation() {
        return this.blockDefIndentation;
    }

    public void setBlockDefIndentation(final Integer blockDefIndentation) {
        this.blockDefIndentation = blockDefIndentation;
    }

    public Integer getIndentation() {
        return getBlockDefIndentation() + 1;
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

}
