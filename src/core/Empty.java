package core;

public class Empty extends Cell {

    public Empty(int x, int y) {
        super(x, y);
        this.s = 'E';
    }


    @Override
    public void updateStatus() {

    }
}
