import java.util.*;
import zones.Zone;

public class ResourcePool {

    private int population;
    private int goods;
    private int lifestyle;

    public ResourcePool(int population, int goods, int lifestyle) {
        this.population = population;
        this.goods = goods;
        this.lifestyle = lifestyle;
    }
    public void addPopulation(int amount) {
        this.population += amount;
    }

    public void addGoods(int amount) {
        this.goods += amount;
    }

    public void addLifestyle(int amount) {
        this.lifestyle += amount;
    }

    public void distributePopulation(List <Zone> targetZones){
        if (targetZones == null || targetZones.isEmpty()) return;
        int amountPerZone= this.population / targetZones.size();
        for (Zone zone : targetZones) {
            zone.receivePopulation(amountPerZone);
        }
        this.population=this.population % targetZones.size();
    }
    public void distributeGoods(List <Zone> targetZones){
        if (targetZones == null || targetZones.isEmpty()) return;
        int amountPerZone = this.goods / targetZones.size();
        for (Zone zone : targetZones){
            zone.receiveGoods(amountPerZone);
        }
        this.goods = this.goods % targetZones.size();
    }
    public void distributeLifestyle(List<Zone> targetZones){
        if (targetZones == null || targetZones.isEmpty()) return;
        int amountPerZone = this.lifestyle / targetZones.size();
        for (Zone zone : targetZones) {
            zone.receiveLifestyle(amountPerZone);
        }
        this.lifestyle = this.lifestyle % targetZones.size();
    }
    public int getPopulation() {return population;}
    public int getGoods() {return goods;}
    public int getLifestyle() {return lifestyle;}

}
