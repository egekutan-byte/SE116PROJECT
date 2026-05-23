package services;

import core.Cell;

public abstract class Service extends Cell {
    protected int radius;

    public Service(int x, int y) {
        super(x, y);
    }

    public int getRadius() {return radius;}

    public abstract void provideService();
}
