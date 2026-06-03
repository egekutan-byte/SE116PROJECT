package utilities;

public class PowerPlant extends UtilityProvider {

    public PowerPlant(int x, int y) {
        super(x, y);
        this.s = 'P';
        this.capacity = 100;
    }

    @Override
    public void updateStatus() {

    }
}
