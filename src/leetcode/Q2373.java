package leetcode;

import java.util.Arrays;

public class Q2373 {

    public static void main(String[] args) {

        // 2373. Largest Local Values in a Matrix
        // - n * n의 Integer 배열의 '그리드'가 있다.
        // - 그리드에서 3 * 3의 쪼갠 그리드에서 최대값으로 만들어진 그리드를 만들어라.
        // - 첫번째 시도: 634ms (완전탐색) -> 2ms (첫 빌드로 인한 시간 계산 에러인걸로 확인)

        int[][] grid = {{9,9,8,1}, {5,6,2,6}, {8,2,6,4}, {6,2,2,2}};

        int[][] result = largestLocal(grid);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static int[][] largestLocal(int[][] grid) {

        int n = grid.length;

        int[][] result = new int[n - 2][n - 2];
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= n - 3; j++) {
                result[i][j] = maxValue(i, j, grid);
            }
        }

        return result;
    }

    public static int maxValue(int y, int x, int[][] grid) {

        int max = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.println(grid[y + i][x + j]);
                max = Math.max(grid[y + i][x + j], max);
            }
        }

        return max;
    }

}
