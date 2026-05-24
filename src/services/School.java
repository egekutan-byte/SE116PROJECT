package services;

import core.Cell;
import zones.Zone;

public class School extends Service {

    public School(int x, int y) {
        super(x, y);
        this.radius=4;
        this.s='S';
    }

    @Override
    public void applyEffect(Zone zone) {
        zone.setHasEducation(true);
    }


    @Override
    public void updateStatus() {

    }



}


