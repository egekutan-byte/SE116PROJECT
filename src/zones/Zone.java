package zones;

import core.Cell;

public abstract class Zone extends Cell {
    protected int level=0;
    public abstract void calculateOutput();
    public abstract void demandUtility();
    protected int currentDemand = 1;

    protected boolean hasElectricity = false;
    protected boolean hasWater = false;
    protected boolean hasInternet = false;
    protected int demandedElectricity = 0;
    protected int demandedWater = 0;
    protected int demandedInternet = 0;
    protected boolean hasSecurity = false;
    protected boolean hasHealth = false;
    protected boolean hasEducation = false;
    protected int receivedElectricity;
    protected int receivedWater;
    protected int receivedInternet;
    

    public void setHasSecurity(boolean hasSecurity) {this.hasSecurity = hasSecurity;}
    public void setHasHealth(boolean hasHealth) {this.hasHealth = hasHealth;}
    public void setHasEducation(boolean hasEducation) {this.hasEducation = hasEducation;}

    protected int currentPopulation = 0;
    protected int currentGoods = 0;
    protected int currentLifestyle = 0;

    public Zone(int x, int y) {
        super(x, y);
    }

    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}


    public int getElectricityDemand() {return demandedElectricity;}
    public int getWaterDemand() {return demandedWater;}
    public int getInternetDemand() {return demandedInternet;}

    public void setHasElectricity(boolean hasElectricity){this.hasElectricity=hasElectricity;}
    public void setHasWater(boolean hasWater){this.hasWater=hasWater;}
    public void setHasInternet(boolean hasInternet){this.hasInternet=hasInternet;}

    public int getCurrentPopulation() {return currentPopulation;}
    public int getCurrentGoods() {return currentGoods;}
    public int getCurrentLifestyle() {return currentLifestyle;}

    public void receivePopulation(int amount){
            this.currentPopulation+=amount;
    }

    public void receiveGoods(int amount){
        this.currentGoods+=amount;
    }

    public void receiveLifestyle(int amount){
        this.currentLifestyle+=amount;
    }

    public void resetUtilities(){
        this.hasElectricity=false;
        this.hasWater=false;
        this.hasInternet=false;
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
