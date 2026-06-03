package zones;

public class Housing extends Zone {
    private int population = 0;
    private int lifestyle = 0;

    public Housing(int x, int y) {
        super(x, y);
        this.s = 'H';
    }

    @Override
    public void demandUtility() {

    }

    public int getPopulation() {
        return population;
    }

    public int getLifestyle() {
        return lifestyle;
    }

    public void updateDemands(int currentOutput) {
        int nextDemand = Math.max(1, currentOutput);

        this.demandedElectricity = nextDemand;
        this.demandedWater = nextDemand;
        this.demandedInternet = nextDemand;
    }

    @Override
    public void calculateOutput() {
        int oldLevel = this.level;
        int m = Math.min(this.receivedElectricity, Math.min(this.receivedWater, this.receivedInternet));

        int targetLevel = 0;
        if (this.receivedElectricity > 0 && this.receivedWater > 0 && this.receivedInternet > 0) {
            targetLevel = 1;
            if (this.hasSecurity && this.hasHealth && this.hasEducation) {
                targetLevel = 2;
                if (this.currentLifestyle > 0) targetLevel = 3;
            }
        }
        if (m == 0) {
            this.level = 0;
        } else if (targetLevel > this.level) {
            this.level++;
        } else if (targetLevel < this.level) {
            this.level--;
        }
        if (this.level == 0) this.population = 0;
        else if (this.level == 1) this.population = m;
        else if (this.level == 2) this.population = 2 * m;
        else if (this.level == 3) this.population = (2 * m) + this.currentLifestyle;
        this.updateDemands(this.population);
        System.out.println("House at (" + this.x + "," + this.y + ") generated " + this.population + " population");
        if (this.level > oldLevel)
            System.out.println("House at (" + this.x + "," + this.y + ") levels up from " + oldLevel + " to " + this.level);
        if (this.level < oldLevel)
            System.out.println("House at (" + this.x + "," + this.y + ") levels down from " + oldLevel + " to " + this.level);
        this.resetUtilities();
    }

    @Override
    public void updateStatus() {
        calculateOutput();
    }
}
