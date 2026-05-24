package services;

import zones.Zone;

public class PoliceStation extends Service{
    public PoliceStation(int x, int y) {
        super(x, y);
        this.radius=5;
        this.s='F';
    }

    @Override
    public void applyEffect(Zone zone) {
        zone.setHasSecurity(true);
    }

    @Override
    public void updateStatus() {

    }
}
