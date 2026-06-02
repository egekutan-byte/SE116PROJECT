package services;

import core.Cell;
import zones.Zone;

public abstract class Service extends Cell {
    protected int radius;

    public Service(int x, int y) {
        super(x, y);
    }

    public int getRadius() {return radius;}


    public abstract void applyEffect(Zone zone);


    public void provideService(Cell[][] grid){
        int minX = Math.max(0, this.x - radius);
        int maxX = Math.min(grid.length - 1, this.x + radius);

        int minY = Math.max(0, this.y - radius);
        int maxY = Math.min(grid.length - 1, this.y + radius);

        for (int i = minX; i <=maxX ; i++) {

            for (int j = minY; j <= maxY; j++) {
                int distance=Math.abs(this.x-i)+Math.abs(this.y-j);

                if(distance<=this.radius){
                    if(grid[i][j] instanceof Zone){
                        Zone targetZone = (Zone) grid[i][j];
                        this.applyEffect(targetZone);
                    }
                }



            }
            
        }

    }
}
