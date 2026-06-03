package core;


import zones.*;
import services.Service;
import utilities.UtilityProvider;

import java.util.ArrayList;
import java.util.List;


public class TickManager {
    private Cell[][] grid;
    private int currentTick = 0;

    private ResourcePool cityPool = new ResourcePool(0, 0, 0);


    public TickManager(Cell[][] grid) {
        this.grid = grid;
    }

    public void nextTick() {
        currentTick++;
        System.out.println("Tick " + currentTick);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] instanceof Service) {
                    Service targetService = ((Service) grid[i][j]);
                    targetService.provideService(grid);
                } else if (grid[i][j] instanceof UtilityProvider) {
                    ((UtilityProvider) grid[i][j]).distributeUtility(grid);
                }
            }
        }

        List<Zone> workplaces = new ArrayList<>();
        List<Zone> commercialZones = new ArrayList<>();
        List<Zone> housingZones = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] instanceof Industrial) {
                    workplaces.add((Zone) grid[i][j]);
                }
                else if (grid[i][j] instanceof Commercial){
                    workplaces.add((Zone) grid[i][j]);
                    commercialZones.add((Zone) grid[i][j]);
                }
                else if (grid[i][j] instanceof Housing){
                    housingZones.add((Zone) grid[i][j]);
                }
            }
        }

        cityPool.distributePopulation(workplaces);
        cityPool.distributeGoods(commercialZones);
        cityPool.distributeLifestyle(housingZones);

        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[i].length ; j++) {
                if(grid[i][j] instanceof Zone){
                    Zone zone=(Zone) grid[i][j];
                    zone.calculateOutput();
                    zone.demandUtility();

                    if (zone instanceof Housing) {
                        cityPool.addPopulation(((Housing) zone).getPopulation());
                    } else if (zone instanceof Industrial) {
                        cityPool.addGoods(((Industrial) zone).getGoodsProduced());
                    } else if (zone instanceof Commercial) {
                        cityPool.addLifestyle(((Commercial) zone).getLifestyleProduced());
                    }
                }
            }
        }

    }

    public void startSimulation(int totalTicks) {
        for (int i = 0; i < totalTicks; i++) {
            this.nextTick();
        }
    }

    private void printMap() {
        System.out.println("\n--- TICK " + currentTick + " ---");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j].s);
            }
            System.out.println();
        }
    }
}
