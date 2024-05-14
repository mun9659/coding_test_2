package leetcode;

public class Q1219 {

    static int n, m, max = 0;
    static boolean[][] visited;
    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    public static void main(String[] args) {

        // 1219. Path with Maximum Gold
        // In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
        // Return the maximum amount of gold you can collect under the conditions:
        //  - Every time you are located in a cell you will collect all the gold in that cell.
        //  - From your position, you can walk one step to the left, right, up, or down.
        //  - You can't visit the same cell more than once.
        //  - Never visit a cell with 0 gold.
        //  - You can start and stop collecting gold from any position in the grid that has some gold.

        // int[][] grid = {{0,6,0}, {5,8,7}, {0,9,0}};
        // int[][] grid = {{1,0,7}, {2,0,6}, {3,4,5}, {0,3,0}, {9,0,20}};
        int[][] grid = {{34,0,1,0,0,0}, {0,0,2,0,1,0}, {5,4,3,7,4,2}, {0,0,5,0,1,4}, {0,0,5,0,2,3}};
        System.out.println(getMaximumGold(grid));

    }

    private static int getMaximumGold(int[][] grid) {

        // 1. 스스로 생각 하건데 BFS/DFS
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0) {
                    System.out.println("dfs 시작 i = " + i + ", j = " + j + " grid[i][j] = " + grid[i][j]);
                    dfs(grid, i, j, grid[i][j]);
                    // max = Math.max(dfs(grid, i, j, 0), max);
                }
            }
        }

        return max;
    }

    private static void dfs(int[][] grid, int n, int m, int sum) {
        System.out.println(n + " | " + m + " : " + sum);

        visited[n][m] = true;

        for(int i = 0; i < 4; i++) {
            int dy = n + dirY[i];
            int dx = m + dirX[i];

            if(rangeCheck(dy, dx) && !visited[dy][dx] && grid[dy][dx] != 0) {
                dfs(grid, dy, dx, sum + grid[dy][dx]);
            }
        }

        visited[n][m] = false;

        max = Math.max(max, sum);
    }

    private static boolean rangeCheck(int y, int x) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
