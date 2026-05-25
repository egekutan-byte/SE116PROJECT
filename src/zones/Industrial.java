package zones;

public class Industrial extends Zone{
    private int receivedPopulation = 0;
    private int generatedGoods = 0;

    public Industrial(int x, int y) {
        super(x, y);
        this.s='I';
    }


    public int getReceivedPopulation() {return receivedPopulation;}
    public void setReceivedPopulation(int receivedPopulation) {this.receivedPopulation = receivedPopulation;}
    public int getGeneratedGoods() {return generatedGoods;}
    public void setGeneratedGoods(int generatedGoods) {this.generatedGoods = generatedGoods;}


    @Override
    public void calculateOutput() {
        int m=Math.min(receivedElectricity,receivedWater);
        if(m==0){
            setLevel(0);
            setGeneratedGoods(0);
            this.currentDemand = 1;
            return;
        }
        if (this.level == 0){
            if (receivedPopulation>0){
                setLevel(1);
            }
        } else if (this.level==1) {
            if(receivedPopulation==0){
                setLevel(0);
            }else {
                if(hasSecurity){
                    setLevel(2);
                }
            }

        } else if (this.level==2) {
            if(hasSecurity==false || receivedPopulation==0){
                setLevel(1);
            }else{
                if (receivedPopulation>1){
                    setLevel(3);
                }
            }
        }else if (this.level==3){
            if (receivedPopulation <=1){
                setLevel(2);
            }
        }
        if (this.level==0){
            setGeneratedGoods(0);
        } else if (this.level==1){
            setGeneratedGoods(m);
        } else if (this.level==2) {
            setGeneratedGoods(2*m);

        } else if (this.level==3) {
            setGeneratedGoods(2*m+receivedPopulation);
        }
        this.currentDemand = Math.max(1, generatedGoods);
    }
}
