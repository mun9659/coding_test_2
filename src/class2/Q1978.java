package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1978 {

    public static boolean[] p_arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());

        Integer[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        // 에라토스테네스의 체
        prime(100);

        int count = 0;

        for(Integer num : arr)
            count += p_arr[num] ? 0 : 1;

        System.out.println(count);

    }

    public static void prime(int n) {
        p_arr = new boolean[n + 1];
        p_arr[0] = p_arr[1] = true;

        if(n < 2) return;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(p_arr[i])
                continue;

            // i의 배수라면 소수가 아니므로 true
            for(int j = i * i; j < p_arr.length; j = j+i) {
                p_arr[j] = true;
            }
        }
    }

}
