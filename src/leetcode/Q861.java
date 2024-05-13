package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Q861 {

    public static void main(String[] args) {

        // 861. Score After Flipping Matrix
        // You are given an m x n binary matrix grid.
        // A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).
        // Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
        // Return the highest possible score after making any number of moves (including zero moves).

        int[][] grid = {{0,0,1,1}, {1,0,1,0}, {1,1,0,0}};
        // int[][] grid = {{0, 1}, {0, 1}, {0, 1}, {0, 0}};

        System.out.println(matrixScore(grid));
    }

    public static int matrixScore(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        // 1. 행 첫번째 값이 0일 경우 Flip 실행
        for(int row = 0; row < n; row++) {
            if(grid[row][0] == 0)
                flipRow(grid, row);
        }

        // 2. 열 1, 0 개수를 체크하여 Flip 여부 확인
        for(int col = 1; col < m; col++) {
            int count = 0;
            for(int row = 0; row < n; row++) {
                if(grid[row][col] == 1)
                    count++;
            }

            if(count * 2 < n)
                flipCol(grid, col);
        }

        int total = 0;
        for(int[] g : grid) {

            total += checkRow(g);

            // String collect = Arrays.stream(g).mapToObj(String::valueOf).collect(Collectors.joining());
            //
            // total += Integer.parseInt(collect, 2);
        }

        return total;
    }

    public static int checkRow(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result = result * 2 + num;
            // result = (result << 1) + num;
        }
        return result;
    }

    public static void flipRow(int[][] grid, int row) {
        for(int col = 0; col < grid[0].length; col++) {
            grid[row][col] = 1 - grid[row][col];
        }
    }

    public static void flipCol(int[][] grid, int col) {
        for(int row = 0; row < grid.length; row++) {
            grid[row][col] = 1 - grid[row][col];
        }
    }

}
