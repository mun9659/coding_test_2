package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 피보나치 0, 1 출력 계산
        long[][] dp = new long[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
            dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
        }

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());

            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }

        System.out.println(sb);
    }
}
