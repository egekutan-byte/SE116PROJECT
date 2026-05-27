package utilities;

public class WaterPumpingStation extends UtilityProvider{

    public WaterPumpingStation(int x, int y, int capacity) {
        super(x, y);
        this.s='W';
        this.capacity=capacity;
    }
}
