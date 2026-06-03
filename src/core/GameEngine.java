package core;

import java.util.ArrayList;

public class GameEngine {
    public static void main(String[] args) {

        String mapFileName="mymap.txt";
        int tickCount=5;

        if(args.length>=2){
            mapFileName=args[0];
            tickCount=Integer.parseInt(args[1]);
        }







        java.util.List<Cell> p=new ArrayList<>();
        java.util.List<Cell> w=new ArrayList<>();
        java.util.List<Cell> t=new ArrayList<>();

        Cell[][] map=MapReader.readMapFile(mapFileName,p,w,t);

        if(map!=null){
            TickManager t1=new TickManager(map);
            t1.startSimulation(tickCount);
        }


    }
}
