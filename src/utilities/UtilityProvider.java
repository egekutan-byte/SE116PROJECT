package utilities;

import core.Cell;

public abstract class UtilityProvider extends Cell {
    protected int capacity=100;

    public UtilityProvider(int x, int y, int capacity) {
        super(x, y);
        this.capacity = capacity;
    }

    abstract void distributeUtility();

}
