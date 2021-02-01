package omar.problems.graphs;

public class ConnectedCellInAGrid {
    public static void main(String[] args) {

    }

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int row=0;row<grid.length;row++){
            for(int column=0; column< grid[0].length;column++){
                if(grid[row][column]==1){
                    if(!visited[row][column]){
                        max = Math.max(max, getRegionSize(grid, row,column, visited));
                    }
                }
            }
        }
        return max;
    }

    private static int getRegionSize(int[][] grid, int row, int column, boolean[][] visited) {
        if(row<0 || column<0 ||row>= grid.length || column>=grid[0].length)
            return 0;


        if(grid[row][column]==0 || visited[row][column])
            return 0;
        visited[row][column]=true;

        int regionSize=1;
        for(int i = row-1; i<=row+1; i++){
            for(int j = column-1; j<=column+1; j++){
                regionSize+=getRegionSize(grid,i,j,visited);
            }
        }

        return regionSize;
    }
    // 0 0 1 2
    // 0 2 3 0
    // 0 0 4 0
    // 1 0 0 0
}
