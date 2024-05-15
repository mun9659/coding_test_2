package leetcode;

import java.util.*;

public class Q2812 {

    public static void main(String[] args) {

        // 2812. Find the Safest Path in a Grid
        // You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:
        // - A cell containing a thief if grid[r][c] = 1
        // - An empty cell if grid[r][c] = 0
        //
        // You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid, including cells containing thieves.
        // The safeness factor of a path on the grid is defined as the minimum manhattan distance from any cell in the path to any thief in the grid.
        // Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).
        // An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.
        // The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val| denotes the absolute value of val.

        // List<List<Integer>> grid = List.of(List.of(1,0,0), List.of(0,0,0), List.of(0,0,1));
        List<List<Integer>> grid = List.of(List.of(0,0,0,1), List.of(0,0,0,0), List.of(0,0,0,0), List.of(1,0,0,0));

        System.out.println(maximumSafenessFactor(grid));
    }

    private static int[] dirX = {1, -1, 0, 0};
    private static int[] dirY = {0, 0, 1, -1};

    private static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        if(grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
            return 0;

        int[][] score = new int[n][n];
        for(int[] row : score) Arrays.fill(row, Integer.MAX_VALUE);
        bfs(grid, score, n);

        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        pq.offer(new int[] {score[0][0], 0, 0});

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            int safe = temp[0];
            int i = temp[1], j = temp[2];

            if(i == n - 1 && j == n - 1) return safe;
            visited[i][j] = true;

            for(int k = 0; k < 4; k++) {
                int dx = i + dirX[k];
                int dy = j + dirY[k];

                if(rangeCheck(dx, dy, n) && !visited[dx][dy]) {
                    int s = Math.min(safe, score[dx][dy]);
                    pq.offer(new int[] {s, dx, dy});
                    visited[dx][dy] = true;
                }
            }
        }

        return -1;
    }

    private static void bfs(List<List<Integer>> grid, int[][] score, int n) {
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    score[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] t = queue.poll();
            int x = t[0], y = t[1];
            int s = score[x][y];

            for(int i = 0; i < 4; i++) {
                int dx = x + dirX[i];
                int dy = y + dirY[i];

                if(rangeCheck(dx, dy, n) && score[dx][dy] > 1 + s) {
                    score[dx][dy] = 1 + s;
                    queue.offer(new int[] {dx, dy});
                }
            }
        }
    }

    private static boolean rangeCheck(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

}
