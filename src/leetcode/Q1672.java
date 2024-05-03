package leetcode;

import java.io.IOException;
import java.util.Arrays;

public class Q1672 {

    public static void main(String[] args) throws IOException {
        // int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        int[][] accounts = {{2,8,7}, {7,1,3}, {1,9,5}};
        // int[][] accounts = {{1, 2, 3}, {3, 2, 1}};

        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {

        int max = 0;

        for(int[] account : accounts) {
            max = Math.max(max, Arrays.stream(account).sum());
        }

        return max;
    }

}
