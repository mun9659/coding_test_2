package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q70 {

    public static void main(String[] args) throws IOException {

        // 70. Climbing Stairs
        // You are climbing a staircase. It takes n steps to reach the top.
        //
        // Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

}
