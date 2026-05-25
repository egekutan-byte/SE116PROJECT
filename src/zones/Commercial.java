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
    public void calculateOutput() {

    }
}
