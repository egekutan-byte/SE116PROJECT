package zones;

public class Industrial extends Zone {
    private int goodsProduced = 0;

    public Industrial(int x, int y) {
        super(x, y);
        this.s = 'I';

    }

    public int getGoodsProduced() {
        return goodsProduced;
    }

    @Override
    public void updateStatus() {
    }

    @Override
    public void calculateOutput() {
        int oldLevel = this.level;
        int m = Math.min(this.receivedElectricity, this.receivedWater);

        int targetLevel = 0;
        if (this.receivedElectricity > 0 && this.receivedWater > 0 && this.currentPopulation > 0) {
            targetLevel = 1;
            if (this.hasSecurity) {
                targetLevel = 2;
                targetLevel = 3;
            }
        }

        if (m == 0 || this.currentPopulation == 0) {
            this.level = 0;
        } else if (targetLevel > this.level) {
            this.level++;
        } else if (targetLevel < this.level) {
            this.level--;
        }

        if (this.level == 0) this.goodsProduced = 0;
        else if (this.level == 1) this.goodsProduced = m;
        else if (this.level == 2) this.goodsProduced = 2 * m;
        else if (this.level == 3) this.goodsProduced = (2 * m) + this.currentPopulation;

        int nextDemand = Math.max(1, this.goodsProduced);
        this.demandedElectricity = nextDemand;
        this.demandedWater = nextDemand;
        this.demandedInternet = nextDemand;

        System.out.println("Industrial at (" + this.x + "," + this.y + ") generated " + this.goodsProduced + " goods");
        if (this.level > oldLevel)
            System.out.println("Industrial at (" + this.x + "," + this.y + ") levels up from " + oldLevel + " to " + this.level);
        if (this.level < oldLevel)
            System.out.println("Industrial at (" + this.x + "," + this.y + ") levels down from " + oldLevel + " to " + this.level);

        this.resetUtilities();
    }

    @Override
    public void demandUtility() {
    }
}
