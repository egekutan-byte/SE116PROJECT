package zones;

import core.Cell;

public abstract class Zone extends Cell {
    protected int level = 0;

    public abstract void calculateOutput();

    public abstract void demandUtility();

    protected int currentDemand = 1;

    protected boolean hasElectricity = false;
    protected boolean hasWater = false;
    protected boolean hasInternet = false;
    protected int demandedElectricity = 1;
    protected int demandedWater = 1;
    protected int demandedInternet = 1;

    protected int currentPopulation = 0;
    protected int currentGoods = 0;
    protected int currentLifestyle = 0;

    protected int receivedElectricity = 0;
    protected int receivedWater = 0;
    protected int receivedInternet = 0;


    protected boolean hasSecurity = false;
    protected boolean hasHealth = false;
    protected boolean hasEducation = false;

    public void setHasSecurity(boolean hasSecurity) {
        this.hasSecurity = hasSecurity;
    }

    public void setHasHealth(boolean hasHealth) {
        this.hasHealth = hasHealth;
    }

    public void setHasEducation(boolean hasEducation) {
        this.hasEducation = hasEducation;
    }

    public Zone(int x, int y) {
        super(x, y);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public int getElectricityDemand() {
        return demandedElectricity;
    }

    public int getWaterDemand() {
        return demandedWater;
    }

    public int getInternetDemand() {
        return demandedInternet;
    }

    public void setHasElectricity(boolean hasElectricity) {
        this.hasElectricity = hasElectricity;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }

    public void setHasInternet(boolean hasInternet) {
        this.hasInternet = hasInternet;
    }

    public int getCurrentPopulation() {
        return currentPopulation;
    }

    public int getCurrentGoods() {
        return currentGoods;
    }

    public int getCurrentLifestyle() {
        return currentLifestyle;
    }

    public void receivePopulation(int amount) {
        this.currentPopulation += amount;
    }

    public void receiveGoods(int amount) {
        this.currentGoods += amount;
    }

    public void receiveLifestyle(int amount) {
        this.currentLifestyle += amount;
    }

    public void resetUtilities() {
        this.hasElectricity = false;
        this.hasWater = false;
        this.hasInternet = false;
        this.receivedElectricity = 0;
        this.receivedWater = 0;
        this.receivedInternet = 0;
        this.hasSecurity = false;
        this.hasHealth = false;
        this.hasEducation = false;
    }

    public void receiveElectricityAmount(int amount) {
        this.receivedElectricity += amount;
    }

    public void receiveWaterAmount(int amount) {
        this.receivedWater += amount;
    }

    public void receiveInternetAmount(int amount) {
        this.receivedInternet += amount;
    }


    public void receiveUtility(utilities.UtilityProvider provider) {
        if (provider.getCapacity() <= 0) return;

        if (provider instanceof utilities.PowerPlant && !this.hasElectricity) {
            this.hasElectricity = true;
            provider.decreaseCapacity(currentDemand);
        } else if (provider instanceof utilities.WaterPumpingStation && !this.hasWater) {
            this.hasWater = true;
            provider.decreaseCapacity(currentDemand);
        } else if (provider instanceof utilities.InternetHub && !this.hasInternet) {
            this.hasInternet = true;
            provider.decreaseCapacity(currentDemand);
        }
    }
}
