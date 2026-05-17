import java.util.*;
import java.io.*;

public class MapReader {
    public static void main(String []args ) {
        String filePath= "mymap.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error: Map file could not be read! " + e.getMessage());
            return;
        }

        int rowCount = lines.size();
        int colCount = 0;

        if (rowCount > 0) {
            colCount = lines.get(0).length();
        }

        char[][] grid = new char[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            grid[i] = lines.get(i).toCharArray();
        }

        System.out.println("Map loaded successfully. Map Size: " + rowCount + "x" + colCount);
        System.out.println("----------------------------------------");

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}