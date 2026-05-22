package utilities;

import core.Cell;

public abstract class UtilityProvider extends Cell {
    protected int capacity=100;

    public UtilityProvider(int x, int y) {
        super(x, y);
    }

    public int getCapacity() {return capacity;}

    public void decreaseCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }

    public void distributeUtility(core.Cell[][] grid){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){

                if (this.capacity <= 0){
                    return;
                }

                core.Cell currentCell = grid[i][j];

                if (currentCell instanceof zones.Zone){
                    zones.Zone building = (zones.Zone) currentCell;
                    building.demandUtility(this);
                }
            }
        }
    }
}
