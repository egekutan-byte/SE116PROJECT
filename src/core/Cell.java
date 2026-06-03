package core;

public abstract class Cell implements Tickable {
    protected int x;//for the x coordinate
    protected int y;//for the y coordinate
    protected char s;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getS() {
        return s;
    }


}
