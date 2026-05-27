package core;
import zones.Zone;
import services.Service;
import utilities.UtilityProvider;



public class TickManager {
    private Cell[][] grid;
    private int currentTick = 0;

    public TickManager(Cell[][] grid) {
        this.grid = grid;
    }

    public void nextTick() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] instanceof Service) {
                    Service targetService = ((Service) grid[i][j]);
                    targetService.provideService();

                } else if (grid[i][j] instanceof UtilityProvider) {
                    ((UtilityProvider) grid[i][j]).distributeUtility(grid);
                }
            }
        }

        if (currentTick > 0) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] instanceof Zone) {
                        ((Zone) grid[i][j]).calculateOutput();
                        ((Zone) grid[i][j]).demandUtility();
                        ((Zone) grid[i][j]).resetUtilities();
                    }
                }
            }
        }

        currentTick++;
        printMap();
    }

    public void startSimulation(int totalTicks){
        for (int i = 0; i < totalTicks; i++) {
            this.nextTick();
        }
    }
























    private void printMap () {
        System.out.println("\n--- TICK " + currentTick + " ---");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; i < grid[i].length; j++) {
                    System.out.print(grid[i][j].s);
                }
                System.out.println();
            }
    }
}
