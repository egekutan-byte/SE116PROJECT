package zones;

public class Housing extends Zone{
    private int population = 0;
    private int lifestyle = 0;

    public Housing(int x, int y) {
        super(x, y);
        this.s='H';
    }

    @Override
    public void demandUtility() {

    }

    public int getPopulation(){return population;}
    public int getLifestyle(){return lifestyle;}

    public void updateDemands(int currentOutput){
        int nextDemand=Math.max(1,currentOutput);

        this.demandedElectricity = nextDemand;
        this.demandedWater = nextDemand;
        this.demandedInternet = nextDemand;
    }

    @Override
    public void calculateOutput() {

        int m = Math.min(this.receivedElectricity, Math.min(this.receivedWater, this.receivedInternet));


        if (m == 0) {
            this.level = 0;
            this.population = 0;
        } else {

            if (this.level == 0 || this.level == 1) {
                this.population = m;
            } else if (this.level == 2) {
                this.population = 2 * m;
            } else if (this.level == 3) {

                this.population = (2 * m) + this.currentLifestyle;
            }
        }


        this.updateDemands(this.population);


        this.resetUtilities();
        this.receivedElectricity = 0;
        this.receivedWater = 0;
        this.receivedInternet = 0;

    }

    @Override
    public void updateStatus() {
        calculateOutput();
    }
}
