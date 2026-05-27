package utilities;

public class PowerPlant extends UtilityProvider{

    public PowerPlant(int x, int y,int capacity) {
        super(x, y);
        this.s='P';
        this.capacity=capacity;
    }
}
