package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        // 1로 만들기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];

        dp[0] = dp[1] = 0;

        // 1. dp 재귀형식
        // int result = recur(n);

        // System.out.println(Arrays.toString(dp));
        // System.out.println(result);

        // 2. for문 처리
        // for(int i = 2; i < n + 1; i++) {
        //     dp[i] = dp[i - 1] + 1;
        //     if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        //     if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        // }
        // System.out.println(dp[n]);

        // 3. 수식 처리
        System.out.println(recur(n, 0));
    }

    // 1. dp 재귀형식
    // public static int recur(Integer n) {

    //     if(dp[n] == null) {

    //         // 6으로 나눌 수 있는 경우
    //         if(n % 6 == 0) {
    //             dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
    //         } 

    //         // 3으로 나눌 수 있는 경우
    //         else if(n % 3 == 0) {
    //             dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
    //         } 

    //         // 2로 나눌 수 있는 경우
    //         else if(n % 2 == 0) {
    //             dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
    //         } 

    //         // 2, 3, 6으로 나눌 수 없을 경우
    //         else {
    //             dp[n] = recur(n - 1) + 1;
    //         }

    //     }

    //     return dp[n];
    // }

    // 3. 수식 처리
    public static int recur(int n, int count) {
        if(n < 2)
            return count;

        return Math.min(recur(n / 2, count + 1 + (n % 2)), recur(n / 3, count + 1 + (n % 3)));
    }
}
