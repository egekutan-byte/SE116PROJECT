package zones;

import core.Cell;

public abstract class Zone extends Cell {
    protected int level=0;
    abstract void calculateOutput();
    abstract void demandUtility();

    public Zone(int x, int y) {
        super(x, y);
    }

    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}
}
