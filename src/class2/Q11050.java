package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11050 {

    // 이항 계수
    // - nCk = n!/(n-k)!k!

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(factorial(n) / (factorial(n - k) * factorial(k)));

    }

    public static int factorial(int num) {
        int result = 1;

        for(int i = 1; i <= num; i++) {
            result *= i;
        }

        return result;
    }

}
