package core;


import zones.*;

import java.util.*;

public class UtilityDistributor {
    static class BFSNode {
        int row;
        int col;
        int remainingCapacity;

        public BFSNode(int row, int col, int remainingCapacity) {
            this.row = row;
            this.col = col;
            this.remainingCapacity = remainingCapacity;
        }
    }

    public static void distribute(Cell[][] grid, int startRow, int startCol, int initialCapacity,String utilityType) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        boolean[][] visited = new boolean[rowCount][colCount];
        Queue<BFSNode> queue = new LinkedList<>();

        queue.add(new BFSNode(startRow, startCol, initialCapacity));
        visited[startRow][startCol] = true;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            BFSNode current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newRow = current.row + dRow[i];
                int newCol = current.col + dCol[i];
                if (newRow >= 0 && newRow < rowCount && newCol >= 0 && newCol < colCount) {
                    if (!visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        Cell neighborCell = grid[newRow][newCol];

                        if (neighborCell instanceof Empty) {
                            continue;
                        }
                        int newCapacity = current.remainingCapacity;

                        if (neighborCell instanceof Zone) {
                            Zone currentZone = (Zone) neighborCell;
                            String zoneName = "";
                            int demand = 0;
                            if (currentZone instanceof Housing) {
                                zoneName = "House";
                            } else if (currentZone instanceof Commercial) {
                                zoneName = "Commercial";
                            } else if (currentZone instanceof Industrial) {
                                zoneName = "Industrial";
                            }
                            if (utilityType.equals("power")) {
                                demand = currentZone.getElectricityDemand();
                                if (current.remainingCapacity >= demand) {
                                    currentZone.setHasElectricity(true);
                                    currentZone.receiveElectricityAmount(demand);
                                    newCapacity = newCapacity - demand;
                                    System.out.println(zoneName + " at (" + currentZone.getX() + "," + currentZone.getY() + ") received " + demand + " electricity");
                                }
                            } else if (utilityType.equals("water")) {
                                demand = currentZone.getWaterDemand();
                                if (current.remainingCapacity >= demand) {
                                    currentZone.setHasWater(true);
                                    currentZone.receiveWaterAmount(demand);
                                    newCapacity = newCapacity - demand;
                                    System.out.println(zoneName + " at (" + currentZone.getX() + "," + currentZone.getY() + ") received " + demand + " water");
                                }
                            } else if (utilityType.equals("internet")) {
                                demand = currentZone.getInternetDemand();
                                if (current.remainingCapacity >= demand) {
                                    currentZone.setHasInternet(true);
                                    currentZone.receiveInternetAmount(demand);
                                    newCapacity = newCapacity - demand;
                                    System.out.println(zoneName + " at (" + currentZone.getX() + "," + currentZone.getY() + ") received " + demand + " internet");
                                }
                            }

                        }
                        if (newCapacity > 0) {
                            queue.add(new BFSNode(newRow, newCol, newCapacity));
                        }
                    }
                }

            }
        }
    }

}

