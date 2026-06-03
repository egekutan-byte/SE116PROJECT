package core;

import services.Hospital;
import services.PoliceStation;
import services.School;
import utilities.InternetHub;
import utilities.PowerPlant;
import utilities.WaterPumpingStation;
import zones.Commercial;
import zones.Housing;
import zones.Industrial;

import java.util.*;
import java.io.*;


public class MapReader {
    public static Cell[][] readMapFile(String filePath, List<Cell> powerPlants, List<Cell> waterStations, List<Cell> internetHubs) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error: Map file could not be read! " + e.getMessage());
            return null;
        }

        int rowCount = lines.size();
        int colCount = 0;

        if (rowCount > 0) {
            colCount = lines.get(0).length();
        }


        Cell[][] grid = new Cell[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            char[] rowChars = lines.get(i).toCharArray();

            for (int j = 0; j < colCount; j++) {
                char currentChar = rowChars[j];


                switch (currentChar) {
                    case 'H':
                        grid[i][j] = new Housing(i, j);
                        break;
                    case 'I':
                        grid[i][j] = new Industrial(i, j);
                        break;
                    case 'C':
                        grid[i][j] = new Commercial(i, j);
                        break;
                    case 'W':
                        grid[i][j] = new WaterPumpingStation(i, j);
                        waterStations.add(grid[i][j]);
                        break;
                    case 'P':
                        grid[i][j] = new PowerPlant(i, j);
                        powerPlants.add(grid[i][j]);
                        break;
                    case 'R':
                        grid[i][j] = new Road(i, j);
                        break;
                    case 'T':
                        grid[i][j] = new InternetHub(i, j);
                        internetHubs.add(grid[i][j]);
                        break;
                    case 'F':
                        grid[i][j] = new PoliceStation(i, j);
                        break;
                    case 'D':
                        grid[i][j] = new Hospital(i, j);
                        break;
                    case 'S':
                        grid[i][j] = new School(i, j);
                        break;
                    case 'E':
                    default:
                        grid[i][j] = new Empty(i, j);
                        break;
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        String filePath = "mymap.txt";
        List<Cell> p = new ArrayList<>();
        List<Cell> w = new ArrayList<>();
        List<Cell> t = new ArrayList<>();

        Cell[][] map = readMapFile(filePath, p, w, t);


        if (map != null) {
            System.out.println("Map loaded successfully.");
            System.out.println("----------------------------------------");
            System.out.println("Found " + p.size() + " Power Plants!");
            System.out.println("Found " + w.size() + " Water Stations!");
            System.out.println("Found " + t.size() + " Internet Hubs!");
            System.out.println("----------------------------------------");
        }
    }
}
