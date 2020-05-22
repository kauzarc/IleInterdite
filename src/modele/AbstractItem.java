package modele;

public abstract class AbstractItem {
    public enum Element {
        fire,
        water,
        earth,
        wind
    }

    private final Element element;

    public AbstractItem(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }
}
