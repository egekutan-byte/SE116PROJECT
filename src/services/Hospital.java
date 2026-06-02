package services;

import zones.Zone;

public class Hospital extends Service{

    public Hospital(int x, int y) {
        super(x, y);
        this.radius=3;
        this.s='D';
    }

    @Override
    public void applyEffect(Zone zone) {
        zone.setHasHealth(true);
    }

    @Override
    public void updateStatus() {

    }
}
