package core;

import java.util.ArrayList;

public class GameEngine {
    public static void main(String[] args) {
        java.util.List<Cell> p=new ArrayList<>();
        java.util.List<Cell> w=new ArrayList<>();
        java.util.List<Cell> t=new ArrayList<>();

        Cell[][] map=MapReader.readMapFile("mymap.txt",p,w,t);

        if(map!=null){
            TickManager t1=new TickManager(map);
            t1.startSimulation(5);
        }


    }
}
