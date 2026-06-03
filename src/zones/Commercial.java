package zones;

public class Commercial extends Zone{
    private int lifestyleProduced = 0;

    public Commercial(int x, int y) {
        super(x, y);
        this.s='C';
    }

    public int getLifestyleProduced() {
        return lifestyleProduced;
    }

    @Override
    public void updateStatus() {}

    @Override
    public void calculateOutput() {
        int oldLevel = this.level;
        int m = Math.min(this.receivedElectricity, Math.min(this.receivedWater, this.receivedInternet));
        int targetLevel = 0;
        if (this.receivedElectricity > 0 && this.receivedWater > 0 && this.receivedInternet > 0 && this.currentPopulation > 0 && this.currentGoods > 0) {
            targetLevel = 1;
            if (this.hasSecurity) {
                targetLevel = 2;
                targetLevel = 3;
            }
        }
        if (m == 0 || this.currentPopulation == 0 || this.currentGoods == 0) {
            this.level = 0;
        } else if (targetLevel > this.level) {
            this.level++;
        } else if (targetLevel < this.level) {
            this.level--;
        }
        if (this.level == 0) this.lifestyleProduced = 0;
        else if (this.level == 1) this.lifestyleProduced = m;
        else if (this.level == 2) this.lifestyleProduced = 2 * m;
        else if (this.level == 3) this.lifestyleProduced = (2 * m) + Math.min(this.currentPopulation, this.currentGoods);
        int nextDemand = Math.max(1, this.lifestyleProduced);
        this.demandedElectricity = nextDemand;
        this.demandedWater = nextDemand;
        this.demandedInternet = nextDemand;
        System.out.println("Commercial at (" + this.x + "," + this.y + ") generated " + this.lifestyleProduced + " lifestyle");
        if (this.level > oldLevel) System.out.println("Commercial at (" + this.x + "," + this.y + ") levels up from " + oldLevel + " to " + this.level);
        if (this.level < oldLevel) System.out.println("Commercial at (" + this.x + "," + this.y + ") levels down from " + oldLevel + " to " + this.level);
        this.resetUtilities();
    }

    @Override
    public void demandUtility() {

    }
}
