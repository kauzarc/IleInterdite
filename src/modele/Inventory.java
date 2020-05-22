package modele;

import observerObservable.Observable;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends Observable {
    private final List<AbstractItem> itemList;
    private final int maxItem;
    private final Container container;

    public Inventory(Container container, int maxItem) {
        this.maxItem = maxItem;
        this.itemList = new ArrayList<>();
        this.container = container;
    }

    private boolean addItem(AbstractItem item) {
        if (this.itemList.size() < this.maxItem) {
            this.itemList.add(item);
            notifyObservers();
            return true;
        }
        return false;
    }

    private boolean remove(int index) {
        if (index >= 0 && index < this.itemList.size()) {
            this.itemList.remove(index);
            return true;
        }
        return false;
    }

    public AbstractItem get(int index) {
        return this.itemList.get(index);
    }

    public boolean moveItemTo(int index, Inventory other) {
        if (other.addItem(this.itemList.get(index))) {
            return remove(index);
        }
        return false;
    }
}
