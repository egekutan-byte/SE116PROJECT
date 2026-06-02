package zones;

public class Commercial extends Zone{
    private int receivedPopulation = 0;
    private int receivedGoods = 0;
    private int generatedLifestyle = 0;

    public Commercial(int x, int y) {
        super(x, y);
        this.s='C';
    }

    public int getReceivedPopulation() {return receivedPopulation;}
    public void setReceivedPopulation(int receivedPopulation) {this.receivedPopulation = receivedPopulation;}
    public int getReceivedGoods() {return receivedGoods;}
    public void setReceivedGoods(int receivedGoods) {this.receivedGoods = receivedGoods;}
    public int getGeneratedLifestyle() {return generatedLifestyle;}
    public void setGeneratedLifestyle(int generatedLifestyle) {this.generatedLifestyle = generatedLifestyle;}

    @Override
    public void calculateOutput() { int m=Math.min(receivedElectricity,Math.min(receivedWater,receivedInternet));

        if(m==0){
            setLevel(0);
            setGeneratedLifestyle(0);
            this.currentDemand=1;
            return;
        }

        if (this.level==0){
            if(receivedPopulation>0 && receivedGoods >0){
                setLevel(1);
            }
        }else if (this.level==1){
            if(receivedPopulation==0 || receivedGoods ==0){
                setLevel(0);
            }else {
                if(hasSecurity){
                    setLevel(2);
                }
            }
        } else if (this.level==2) {
            if(hasSecurity == false || receivedPopulation == 0 || receivedGoods == 0){
                setLevel(1);
            }else {
                if(receivedPopulation >1 && receivedGoods >1){
                    setLevel(3);
                }
            }
        } else if (this.level==3) {
            if(receivedPopulation <=1 || receivedGoods<=1){
                setLevel(2);
            }
        }
        if (this.level==0){
            setGeneratedLifestyle(0);
        } else if (this.level==1) {
            setGeneratedLifestyle(m);
        } else if (this.level ==2) {
            setGeneratedLifestyle(2*m);
        } else if (this.level==3) {
            setGeneratedLifestyle((2*m) +Math.min(receivedPopulation,receivedGoods));
        }
        this.currentDemand = Math.max(1,generatedLifestyle);
    }

    @Override
    public void demandUtility() {
        this.demandedElectricity=currentDemand;
        this.demandedWater=currentDemand;
        this.demandedInternet=currentDemand;
    }

    @Override
    public void updateStatus() {
        calculateOutput();
    }
}
