package utilities;

public class WaterPumpingStation extends UtilityProvider {

    public WaterPumpingStation(int x, int y) {
        super(x, y);
        this.s = 'W';
        this.capacity = 100;
    }

    @Override
    public void updateStatus() {

    }
}
