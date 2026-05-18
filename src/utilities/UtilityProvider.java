package utilities;

import core.Cell;

public abstract class UtilityProvider extends Cell {
    protected int capacity=100;

    public UtilityProvider(int x, int y) {
        super(x, y);
    }

    public int getCapacity() {return capacity;}

    abstract void distributeUtility();

}
