package utilities;

import core.*;

public abstract class UtilityProvider extends Cell {
    protected int capacity=100;

    public UtilityProvider(int x, int y) {
        super(x, y);
    }

    public int getCapacity() {return capacity;}

    public void decreaseCapacity(int amount) {
        if (capacity > 0) {
            this.capacity -= amount;

            if (this.capacity < 0){
                this.capacity = 0;
            }
        }
    }

    public void distributeUtility(core.Cell[][] grid){
        String type = "";
        if (this instanceof PowerPlant) type = "power";
        else if (this instanceof WaterPumpingStation) type = "water";
        else if (this instanceof InternetHub) type = "internet";


        UtilityDistributor.distribute(grid, this.x, this.y, this.capacity, type);
    }
}
