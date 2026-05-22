package zones;

import core.Cell;

public abstract class Zone extends Cell {
    protected int level=0;
    abstract void calculateOutput();
    protected boolean hasElectricity = false;
    protected boolean hasWater = false;
    protected boolean hasInternet = false;

    public Zone(int x, int y) {
        super(x, y);
    }

    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}

    public void demandUtility(utilities.UtilityProvider provider) {
        if (provider.getCapacity() <= 0) return;

        if (provider instanceof utilities.PowerPlant && !this.hasElectricity) {
            this.hasElectricity = true;
            provider.decreaseCapacity();
        } else if (provider instanceof utilities.WaterPumpingStation && !this.hasWater) {
            this.hasWater = true;
            provider.decreaseCapacity();
        } else if (provider instanceof utilities.InternetHub && !this.hasInternet) {
            this.hasInternet = true;
            provider.decreaseCapacity();
        }
    }
}
