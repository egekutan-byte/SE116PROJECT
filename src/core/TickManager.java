package core;
import zones.Zone;
import services.Service;
import utilities.UtilityProvider;



public class TickManager {
    private Cell[][] grid;
    private int currentTick=0;

    public TickManager(Cell[][] grid) {
        this.grid = grid;
    }

    public void nextTick(){

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length ; j++) {
                    if(currentTick==0){
                    if(grid[i][j] instanceof Service){
                        ((Service) grid[i][j]).provideService();
                    }
                    else if(grid[i][j] instanceof UtilityProvider){
                        ((UtilityProvider) grid[i][j]).distributeUtility(grid);
                    }
                    }
                    else{
                        if(grid[i][j] instanceof Zone){
                            ((Zone)grid[i][j]).calculateOutput();
                            ((Zone)grid[i][j]).demandUtility();
                        }
                    }
                }
            }
            currentTick++;

    }
}
