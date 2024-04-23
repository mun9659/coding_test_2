package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2579 {

    static int[] stair;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // 계단 오르기
        // 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
        // 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
        // 3. 마지막 도착 계단은 반드시 밟아야 한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        stair = new int[n + 1];
        dp = new int[n + 1];

        for(int i = 1; i <= n; i++)
            stair[i] = Integer.parseInt(br.readLine());

        dp[1] = stair[1];

        if(n >= 2) {
            dp[2] = stair[1] + stair[2];
        }

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
        }

        System.out.println(dp[n]);

    }

}
