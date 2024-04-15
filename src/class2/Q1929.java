package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1929 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 에라토스테네스의 체
        boolean[] primeArr = new boolean[n + 1];
        primeArr[0] = primeArr[1] = true;

        for(int i = 2; i < primeArr.length; i++) {

            if(primeArr[i]) continue;

            for(int j = i + i; j < primeArr.length; j += i) {
                primeArr[j] = true;
            }
        }

        for(int i = m; i <= n; i++) {
            if(!primeArr[i])
                sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
