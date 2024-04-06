package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2775 {

    public static int[][] dp = new int[15][15];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        // 0층의 i호에는 i명이 산다.
        for(int i = 0; i < 15; i++) {
            for(int j = 1; j < 15; j++) {
                if(i == 0) dp[i][j] = j;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        for(int i = 0; i < t; i++) {
           int k = Integer.parseInt(br.readLine()); // 층
           int n = Integer.parseInt(br.readLine()); // 호수

            System.out.println(dp[k][n]);
        }
    }
}
