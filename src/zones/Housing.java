package zones;

public class Housing extends Zone{
    private int population = 0;
    private int lifestyle = 0;

    public Housing(int x, int y) {
        super(x, y);
        this.s='H';
    }

    public int getPopulation(){
        return population;
    }
    public int getLifestyle(){
        return lifestyle;
    }

    @Override
    public void calculateOutput() {
        int utilityCount = 0;
        if (this.hasElectricity){
            utilityCount++;
        }
        if (this.hasWater){
            utilityCount++;
        }
        if (this.hasInternet){
            utilityCount++;
        }

        if (utilityCount == 0){
            this.level = 0;
            this.population = 0;
            this.lifestyle = 0;
        }else {
            this.level = utilityCount;
            this.population = this.level * 5;
            this.lifestyle = this.level * 10;
        }

        this.hasElectricity = false;
        this.hasWater = false;
        this.hasInternet = false;
    }

    @Override
    public void updateStatus() {
        calculateOutput();
    }
}
