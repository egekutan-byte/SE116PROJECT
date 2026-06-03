package services;

import core.Cell;
import zones.*;

public abstract class Service extends Cell {
    protected int radius;

    public Service(int x, int y) {
        super(x, y);
    }

    public int getRadius() {
        return radius;
    }

    public void provideService(core.Cell[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;


        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {


                if (grid[i][j] instanceof Zone) {
                    Zone targetZone = (Zone) grid[i][j];


                    int distance = Math.abs(this.x - targetZone.getX()) + Math.abs(this.y - targetZone.getY());


                    if (distance <= this.radius) {
                        String zoneName = "";
                        String serviceName = "";

                        // Binanın tipini tamamen düz if-else ile buluyoruz
                        if (targetZone instanceof Housing) {
                            zoneName = "House";
                        } else if (targetZone instanceof Commercial) {
                            zoneName = "Commercial";
                        } else if (targetZone instanceof Industrial) {
                            zoneName = "Industrial";
                        }
                        if (this instanceof PoliceStation) {
                            targetZone.setHasSecurity(true);
                            serviceName = "security";
                        } else if (this instanceof Hospital) {
                            targetZone.setHasHealth(true);
                            serviceName = "health";
                        } else if (this instanceof School) {
                            targetZone.setHasEducation(true);
                            serviceName = "education";
                        }
                        System.out.println(zoneName + " at (" + targetZone.getX() + "," + targetZone.getY() + ") received " + serviceName + " service");
                    }
                }
            }
        }
    }
}
